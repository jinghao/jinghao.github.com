---
layout: post
title: WiFi Problems
created: 1300674778
categories:
- wireless
- wifi
---
As of last night, my laptop's wireless is basically unusable. Here's what happens when I try to ping google.com (The same thing happens even if I ping 192.168.1.1 or yahoo.com):

<pre>C:\Users\Yan>ping -t google.com

Pinging google.com [74.125.225.19] with 32 bytes of data:
Request timed out.
Request timed out.
Request timed out.
Reply from 74.125.225.19: bytes=32 time=65ms TTL=53
Reply from 74.125.225.19: bytes=32 time=65ms TTL=53
Request timed out.
Request timed out.
Request timed out.
Request timed out.
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Request timed out.
Request timed out.
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Reply from 74.125.225.19: bytes=32 time=65ms TTL=53
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Request timed out.
Request timed out.
Request timed out.
Request timed out.
Reply from 74.125.225.19: bytes=32 time=193ms TTL=53
Reply from 74.125.225.19: bytes=32 time=65ms TTL=53
Reply from 74.125.225.19: bytes=32 time=86ms TTL=53
Reply from 74.125.225.19: bytes=32 time=73ms TTL=53
Request timed out.
Request timed out.
Request timed out.
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Reply from 74.125.225.19: bytes=32 time=68ms TTL=53
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Request timed out.
Reply from 74.125.225.19: bytes=32 time=65ms TTL=53
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Reply from 74.125.225.19: bytes=32 time=65ms TTL=53
Reply from 74.125.225.19: bytes=32 time=84ms TTL=53
Reply from 74.125.225.19: bytes=32 time=67ms TTL=53
Request timed out.
Reply from 74.125.225.19: bytes=32 time=93ms TTL=53
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Request timed out.
Request timed out.
Request timed out.
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Request timed out.
Request timed out.
Request timed out.
Request timed out.
Request timed out.
Request timed out.
Reply from 74.125.225.19: bytes=32 time=87ms TTL=53
Request timed out.
Reply from 74.125.225.19: bytes=32 time=65ms TTL=53
Reply from 74.125.225.19: bytes=32 time=86ms TTL=53
Request timed out.
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53</pre>

As you can see, half of the ping requests don't finish. Normally this would be a sign of congested airspace, but of the five devices connected to the router, <strong>mine is the only one having such problems</strong>--others are still buzzing along just fine. As a result, I have to plug in my Ethernet cable.

I've been trying to fix this issue since last night because being forced to sit at most five feet away from the router is too uncomfortable. I uninstalled the only thing I installed in between when the wireless worked, and when it stopped working (A software for a print server, which surprisingly didn't work). I tried restarting numerous times. I tried disabling and re-enabling my wireless adapter. I tried to disable my firewall/adjust settings.

I don't know what's wrong: I did not install any Windows updates in between, there are no new drivers for my device, and Windows doesn't report any problems (nor does the troubleshooter give any helpful advice). I've wasted numerous hours dealing with WiFi problems both at home and on campus. Why does it have to be such an unreliable system?

Any advice for me? Feel free to vent your WiFi frustrations here too.

EDIT: Figured out the problem. Jack left, and now I can connect just fine wirelessly:

<pre>C:\Users\Yan>ping google.com

Pinging google.com [74.125.225.19] with 32 bytes of data:
Reply from 74.125.225.19: bytes=32 time=68ms TTL=53
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53
Reply from 74.125.225.19: bytes=32 time=84ms TTL=53
Reply from 74.125.225.19: bytes=32 time=66ms TTL=53</pre>

What was his computer doing that was disabling my internet?
