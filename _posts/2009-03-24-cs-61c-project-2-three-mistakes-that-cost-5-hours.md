---
layout: post
title: 'CS 61C Project 2: Three Mistakes That Cost 5 Hours'
created: 1237913971
categories: school programming programming mishaps
---
Three things, one directly my fault and the other two not, caused me to waste eight otherwise-productive hours on the second project. You'll see how ridiculous those three things are.

I thought I had a completely functional submission yesterday morning. All I needed to do was to use the test script once to verify that. But when I uploaded it, the test script wouldn't even run. After some time of research (my professor was out of town and nobody else had the same problems), I discovered that it was because I was running Bash as my default shell. I changed that to csh (C-shell) and now the script finally ran.

I failed every test. It gave me absolutely useless explanations for why I failed them, but I found one lethal error that could have caused me to fail them all: instead of using <code>sb $0, 0($a0)</code> to save a null character, I used <code>lb $0, 0($a0)</code> (which obviously doesn't work). After I fixed that (using notepad), I uploaded the file again, and it still failed all the tests. I read through the code again, but I found no bugs!

I opened Mars (our MIPS assembler) and tried running the code, and surprisingly it worked, so I saved it (even though I made no changes) and uploaded it. And now the tests don't complain that they failed--instead they complain about some command not being found. After Googling a bit, I realized that that command isn't in csh, but it's in tcsh. So I changed my shell to that, and program passed all tests--yay!

Now that I was confident my code worked, I put off the last part--commenting the code (yup, the whole assembly file was nearly uncommented when I wrote it) until 10:40. But after commenting, the code stopped working--it failed all the tests again! I was so confused! So I replaced code bit by bit to see what made it work, and only at 11:55 did I figure out that this whole time, the only reason the test script failed me completely was that I didn't have a newline at the very end of my program.

And this is also why opening and saving in Mars, even with no changes, fixed my program up above (paragraph 2). Isn't that stupid? How should I have known that I shouldn't use Notepad to edit my program? (it doesn't automatically add a newline) How should I have known that the script works only on tcsh? I suppose it was unwise of me to change my settings away from the default, but isn't that what settings are for?

Part of it was lack of documentation on Clancy (my professor)'s part--a simple "The script only works on tcsh and on newline-terminated code" would have sufficed to save me 4 hours! The other part was a bona fide mistake of a programmer. (I made one typo!) But together they were disaster because nobody else had the same problems. Lesson: There are dangers to doing things unconventionally.
