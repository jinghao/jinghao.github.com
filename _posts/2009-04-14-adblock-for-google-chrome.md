---
layout: post
title: AdBlock for Google Chrome
created: 1239767409
categories: programming
---
The one major problem with Chrome is that, unlike Mozilla Firefox, it is backed by a gigantic corporation whose goal is to maximize return to shareholders. Despite its performance and design advantages, it misses many of the advantages of being a community-developed software, including extensibility.

Obviously we cannot rely on Google to include in its own browser the feature that directly opposes its whole business model based on advertising. But recently Google added some features to support extensibility and developers are taking full advantage of that. The first such is Adblock.

Because Chrome does not yet have a fully-functional extension system, everything must be done manually. To simplify the task, I've created a [simple executable file](/uploads/AdBlockforChrome.exe) that saves a [Javascript file](/uploads/adblock.js.txt) and a configuration file in a <code>Program Files</code> directory and instructs you on how to enable the addon. Finally there is a <em>solution without installing a private proxy (Privoxy), as suggested by all other solutions, which incurs extra system overhead</em>. Many thanks to [Mark8t](http://www.mark8t.com/2009/03/20/creating-google-chrome-extensions-beta-adblock-for-chrome/) for the original code.

Bonus feature: Configure your exceptions list by following the instructions at the end of the installation.

**CliffsNotes Edition:** Just [download the installation file (click here)](/uploads/AdBlockforChrome.exe), run it, and follow the brief instructions at the end to enjoy ad-free browsing. Have fun! (Obviously this works only on Windows) Note: You MUST **update and close** Google Chrome before installing this.

If you like this, please [Digg it](http://digg.com/software/AdBlock_for_Google_Chrome_5) and share it with your friends.
