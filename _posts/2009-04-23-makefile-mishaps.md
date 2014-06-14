---
layout: post
title: Makefile Mishaps
created: 1240540131
tags: programming programming mishaps
---
I can't claim to be familiar with Makefiles, but after these mishaps I can confidently assert that I've learned a thing or two about them.

The first error was easy to catch and fix: Tabs and spaces are completely different! For each label, the dependencies list must come after a space, not a tab; but the instructions must be tab-prefixed.

The second error took hours (and the help of my CS professor) to figure out: Makefiles should NOT contain the \r (linefeeds) that are inserted by Windows text editors but are invisible in almost all text editors in their default settings. I could not make anything of the inscrutable error I got each time: ``'ake: Fatal error: Don't know how to make target `main.o` ``. Why? Because the Makefile itself looked just fine! I've made Makefiles before, and that's what they all looked like. It wasn't until my professor opened up my Makefile in `vi` did he see that it had those Windows characters that nix systems dislike. Whoops. There goes three hours.

The third problem I did not even detect until I heard that I failed every automated test on my program. I was appalled by that! I was absolutely certain my code was functional and worked correctly. It turns out, I must insert a @ in front of my instructions in order to suppress Make's output to `stdout`. When my output was compared to the correct output, it was off by the output from Make. Whoops.

So if you ever need to deal with Makefiles, just make sure you keep these things in mind. Otherwise, Makefiles are intuitively pretty simple.
