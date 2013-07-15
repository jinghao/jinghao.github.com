---
layout: post
title: Olympic Medal Counts
created: 1219176024
categories: []
---
<p>What is an Olympic gold worth to you? Specifically, how many bronze or silver medals would you give up for a single gold? I made this script which downloads data from Wikipedia and calculates the equivalent gold medals. Now people can stop complaining about how China ranks countries by number of gold medals and the United States ranks countries by total medals.</p>

<p>Notes: (1) the cache is updated hourly, so this may not reflect the most recent competitions; (2) the default values are based on relative densities of the three metals. Enjoy.</p>
<?php
function file_get_contents_external($file_url, $callback = false) {
	$url_parts = parse_url($file_url);
	
	if($socket = @fsockopen($url_parts['host'], 80)) {
		fwrite($socket, "GET {$url_parts['path']}?{$url_parts['query']} HTTP/1.1\r\n".
						"Host: {$url_parts['host']}\r\n".
						"Accept-Charset: utf-8, *;q=0.1\r\n".
						"\r\n".
						"\r\n");

		// grab the output one line at a time until end is reached
		while (!feof($socket)) {
			$line = fgets($socket);
			
			if($callback and $line = $callback($line)) {
				return $line;
			}
			
			$content .= $line;
		}

		@fclose($socket);
		return $content;
	}
	
	return false;
}

function get_fields($line) {
	global $medals_by_country;
	if(preg_match("#\{\{flagIOCteam\|([A-Z]{3})\|2008 Summer\}\} \|\|([\d\s]+)\|\|([\d\s]+)\|\|([\d\s]+)\|\|([\d\s]+)#", $line, $match)) {
		$medals_by_country[$match[1]] = array (
			'gold' => intval(get_number($match[2])),
			'silver' => intval(get_number($match[3])),
			'bronze' => intval(get_number($match[4])),
			'total' => intval(get_number($match[5])),
			);
	} else if(preg_match("#sortbottom#", $line)) {
		return true;
	}
}

function get_number($numStr) {
	return preg_replace("/[^0-9\.]/", "", $numStr);
}

function make_select($name, $selected = false) {
	global $medals_by_country;

	$return .= "<select name=\"$name\">\n";
	foreach($medals_by_country as $country => $medals) {
		$return .= "\t<option value=\"$country\"".($selected == $country ? " selected=\"selected\"" : "").">$country</option>\n";
	}
	$return .= "</select>\n";

	return $return;
}

function get_points($country) {
	global $medals_by_country, $bronze, $silver;

	return round($medals_by_country[$country]['gold'] + $medals_by_country[$country]['silver'] / $silver + $medals_by_country[$country]['bronze'] / $bronze, 0);
}

$cache = "sites/dailycow.org/files/medals_cache.txt";

global $medals_by_country, $bronze, $silver;

include $cache;

if(time() > filemtime($cache) + 3600 or !isset($medals_by_country)) {// if cache is more than an hour old, update cache
	file_get_contents_external("http://en.wikipedia.org/w/index.php?title=2008_Summer_Olympics_medal_table&action=edit", "get_fields");
	
	file_put_contents($cache, "<"."?php\n\$medals_by_country = ".var_export($medals_by_country, true).";\n?".">");
}

ksort($medals_by_country);

$country1 = isset($medals_by_country[$_REQUEST['country1']]) ? $_REQUEST['country1'] : 'CHN';
$country2 = isset($medals_by_country[$_REQUEST['country2']]) ? $_REQUEST['country2'] : 'USA';
$bronze = $_REQUEST['bronze'] > 0 ? get_number($_REQUEST['bronze']) : 2.33;
$silver = $_REQUEST['silver'] > 0 ? get_number($_REQUEST['silver']) : 1.84;

?>
<form action="/medals" method="post"><input type="submit" value="Compare" /> <?php echo make_select("country1", $country1); ?> and <?php echo make_select("country2", $country2); ?> if one <strong>gold</strong> medal equals either of the following:
<ul>
<li><input type="text" name="bronze" size="10" value="<?php echo $bronze ?>" /> <strong>bronze</strong> medals</li>
<li><input type="text" name="silver" size="10" value="<?php echo $silver ?>" /> <strong>silver</strong> medals</li>
</ul></form>
<?php

$points = array(get_points($country1), get_points($country2));

echo "Raw data and equivalents in gold:
<ul>
<li><strong>$country1</strong> has <strong>{$medals_by_country[$country1][gold]}</strong> gold medals, <strong>{$medals_by_country[$country1][silver]}</strong> silver medals and <strong>{$medals_by_country[$country1][bronze]}</strong> bronze medals, the equivalent of <strong>$points[0]</strong> gold medals.</li>
<li><strong>$country2</strong> has <strong>{$medals_by_country[$country2][gold]}</strong> gold medals, <strong>{$medals_by_country[$country2][silver]}</strong> silver medals and <strong>{$medals_by_country[$country2][bronze]}</strong> bronze medals, the equivalent of <strong>$points[1]</strong> gold medals.</li>
</ul>
<p>Therefore, the winner between the two is <strong>";
if($points[1] > $points[0])
	echo $country2;
elseif($points[1] < $points[0])
	echo $country1;
else
	echo "neither (it is a tie)";
echo "</strong></p>";
?>
