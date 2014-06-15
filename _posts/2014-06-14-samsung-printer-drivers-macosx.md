---
layout: post
title: "How to install Samsung ML-2510 printer drivers on Mac OS X"
tags: [samsung, printers, how-to, "Mac OSX"]
---
Printers are notoriously difficult to install and operate, especially on non-PCs. It's difficult to fathom why there needs to be so much complexity in an operation that's mostly standard across devices.

I recently had to print something, and needed to install the drivers for my printer on my Macbook Air. The printer's about five years old, and there aren't official OS X drivers for the model online. But you can still make it work!

Here's what I had to do:

1. Download and install the generic Samsung drivers: http://support.apple.com/kb/DL905
2. Add a printer using the `Printers & Scanners` dialog.
3. Choose "Samsung ML-2510 Series"
4. Under the "Choose a Driver" dropdown, choose "Select Software". This is where it gets tricky because there is no driver for Samsung ML-2510. I tried the driver for ML-2540 (which seems like a slightly newer version of ML-2510), but that didn't work. When I tried to print, it simply printed `INTERNAL ERROR - FALSE`. So I tried ML-2240, which worked. If your model is different, you just have to try some and see which works.

Why can't every printer just adopt a standard protocol?