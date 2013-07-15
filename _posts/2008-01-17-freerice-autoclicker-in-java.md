---
layout: post
title: FreeRice AutoClicker, in Java!
created: 1200640891
categories: []
---
Over the break, among other things, I learned (through practice) the fundamentals of Java (For everything else, I just use Google) and as my first project in this language, I wrote a (client-side) Java application for my <a href="http://dailycow.org/node/165">FreeRice AutoClicker 1.4</a> (for those who don't remember).

<h3>What's different about this application?</h3>

Besides the fact that it's now written in Java and is not meant to be run on a webserver? (It actually runs on this server, though)
<ol>
<li>The whole brute force (guessing) part has largely been eliminated; subsequent selections of the same answer choice are just as effective as the first (so rice is still donated when you "click" the same choice repeatedly).</li>
<li>Multithreading has been removed because the server-side bottleneck appears to be gone (FreeRice.com used to check against quick consecutive requests). </li>
<li>The application now processes the input stream (containing the return data from the socket to www.freerice.com) one line at a time and only as far as needed in order to speed up execution and eliminate unnecessary bandwidth usage.</li>
<li>Just to make the cumulative effects of the aforementioned changes obvious, I've included a timer that shows you how fast the application is donating rice (I get 310 grains/second on my wireless connection).</li>
</ol>
So, what does all that mean? As a result of these changes, the application executes around four times faster than the PHP-CLI version.

<h3>I don't believe you</h3>

As always, the well-documented source code (the .java file) is provided for <s>entertainment</s>educational purposes. If you don't believe that the application can actually ping freerice.com that fast, you can set <code>forceCheck</code> (defined at the beginning of the class definition: <code>private static final boolean forceCheck = false;</code>) to <code>true</code> and the script will manually confirm that each submission counts by looping through the output stream line-by-line and checking whether the keyword "<code>correctDef</code>" is present (you have to recompile the .java file, though). But I warn you that setting <code>forceCheck</code> to <code>true</code> will slow execution considerably since it requires the application to wait for the freerice.com server to completely respond, so this might not be the best idea if you just want to donate a bunch of rice.

<h3>How do I run this?</h3>

You probably have some version of Java installed on your machine, so open a terminal (on *nix systems)/DOS (on Windows) and <code>cd</code> to the directory containing the .class file, type <code>java FreeRice</code>, enter, and you're set. If you don't have the guts to trust my compilation, you can download the source code, review it for possible exploits (trust me--there are none), and compile it yourself (<code>cd</code> to the directory containing the .java file and type <code>javac FreeRice.java</code>)--then follow the instructions above to execute the compiled .class file.

<h3>What's next?</h3>

Possibly a version written in C# (to run on Mono on *nix systems or .NET on Windows), C++ (individual compilations) or Python.

Enjoy, and don't forget to <a href="http://digg.com/software/FreeRice_AutoClicker_now_in_Java"><strong>Digg</strong></a> &amp; <a href="http://www.stumbleupon.com/url/dailycow.org/node/200"><strong>StumbleUpon</strong></a> this article and <a href="http://berkeley.facebook.com/group.php?gid=7813673210"><strong>join other skeptics at Facebook</strong></a> so you can help others discover how to alleviate world hunger (if it isn't a scam)! Also, I urge everyone to post their donation totals--I'm curious how large of an impact this application can make.
