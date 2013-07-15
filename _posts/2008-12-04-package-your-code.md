---
layout: post
title: Package Your Code
created: 1228459462
categories: []
---
Don't make my mistake. I was without Internet and couldn't find which Java package comes with an array-reverse method, so I coded my own.

It sounded simple: Loop through each element, put the element in question in a temporary variable, and switch that element with the corresponding element from the end. But for the life of me, I couldn't figure out why it didn't do ANYTHING. I thought at first it had to do with the scope, but that wasn't consistent with my understanding of the Java language. It took me almost half an hour before I figured out what was wrong with my four-line code.

If I reverse every pair, I would've reversed the array twice. Whoops.

So take this as a lesson, fellow CS-ers: Have a debugged package of code that you can use during rainy days (times without Internet access), so you don't have to spend hours fiddling with your logic to find where you made that silly mistake.
