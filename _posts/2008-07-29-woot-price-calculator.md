---
layout: post
title: Woot Price Calculator
created: 1217349099
categories:
- woot
---
<p>One of the most annoying things about Woot.com is that it doesn't list the prices of past items, even during Woot-offs, so you can't regret not staying up till four to buy that $10 RC copter. Often, there will be Woot-bots that post the item's price on Woot's discussion boards, but sometimes when Woots appear in quick successions, the bots miss the price.</p>

<p>So, I made the following script to simplify our price-finding task. It works for all past Woots (for current ones, just go to woot.com). Paste the link to the blog or discussion page of the corresponding item, and the script will tell you its price (Click <a href="/woot">read more</a> for the form). Disclaimer: Accuracy not guaranteed.</p>

<?php
function file_get_contents_external($file_url, $callback = false) {
	$url_parts = parse_url($file_url);
	#print " loading ";print_r($url_parts);print "\nCallback = $callback\n";
	if($socket = fsockopen($url_parts['host'], 80)) {
		fwrite($socket, "GET {$url_parts['path']}?{$url_parts['query']} HTTP/1.1\r\n".
						"Host: {$url_parts['host']}\r\n".
						"Accept-Charset: utf-8, *;q=0.1\r\n".
						"\r\n".
						"\r\n");

		// grab the output one line at a time until end is reached
		while (!feof($socket)) {
			$line = fgets($socket);
			
#print "<!-- line = $line -->\n";
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

function get_discussion($line) {
  static $in_footer;

  if (!$in_footer) {
    if (preg_match("#blogFooter#", $line)) {
      $in_footer = true;
    }
  }
  if ($in_footer and preg_match("#href=\"(http://www\.woot\.com/Forums/ViewPost\.aspx\?PostID=\d+)\"#", $line, $match)) {
    file_get_contents_external($match[1], "get_javascript");
    return true;
  }

  return false;
}

function get_javascript($line) {
	if(preg_match("#script src=\"(http://www\.woot\.com/scripts/dynamic\.aspx\?control=salesummary&saleid=\d+)\"#", $line, $match)) {
		file_get_contents_external($match[1], "get_fields");
		
		return true;
	}
	
	return false;
}

function get_fields($line) {
  if (preg_match("#Order pace: ([\.,\d]+)m ([\.,\d]+)s#", $line, $match)) {
    $pace = get_number($match[1]) * 60 + get_number($match[2]);
  }

  if (preg_match("#Woot wage: \\$([\.,\d]+)[^\d]#", $line, $match)) {
    $wage = get_number($match[1]);
    echo "<p>The item costs <strong>$".round($wage * $pace / 3600, 2)."</strong> + $5 shipping.</p>";
    return true;
  }

  return false;
}

function get_number($numStr) {
	return preg_replace("/[^0-9\.]/", "", $numStr);
}


if($_POST['wooturl']) {
	echo "<p>Loading ".htmlspecialchars($_POST['wooturl'])."...</p>";
	file_get_contents_external($_POST['wooturl'], preg_match("#Blog#", $_POST['wooturl']) ? "get_discussion" : "get_javascript");
}
?>
<!--break-->
<script type="text/javascript"><!--
google_ad_client = "pub-8036490252692174";
/* Woot on Dailycow */
google_ad_slot = "2252848475";
google_ad_width = 468;
google_ad_height = 60;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script><form action="woot" method="post"><p><input size="40" type="text" name="wooturl" value="<?php echo $_POST['wooturl'] ?>" /><input type="submit" value="Calculate!" /></p></form>
<p>If you liked this script, don't forget to go <a href="http://digg.com/software/Woot_com_Price_Finder" rel="external">here</a> to Digg this!</p>
