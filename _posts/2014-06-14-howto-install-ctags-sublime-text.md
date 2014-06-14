---
layout: post
title: "How to install CTags on Sublime Text"
categories: [sublime-text, ctags, how-to, "Mac OSX"]
---
CTags is a program that generates an index of tokens (i.e. function names and other identifiers). By integrating it into Sublime Text, you can enable quick navigate-to-symbol.

I just installed it and it works surprisingly well. The instructions are at https://github.com/SublimeText/CTags but there are a few more Mac-specific details:

* See the note on the readme about using the proper version of `ctags`.
* To find your Sublime Text packages folder, go to `/Users/{user}/Library/Application Support/Sublime Text 2/Packages` or choose `Sublime Text 2` -> `Preferences` -> `Browse Packages`. This is where you should extract the plugin.

There are additional configurations such as keymaps in that folder. I modified `Default.sublime-keymap` to be closer to the `vim` keys I was familiar with.