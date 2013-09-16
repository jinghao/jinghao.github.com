---
layout: post
title: Incontrovertible Evidence That FreeRice Is a Scam
created: 1201998864
categories: []
---
First off, I would like to thank everyone for their support, contributions and enthusiasm in our [February 1st FreeRice Campaign](http://dailycow.org/ricecampaign). You have all done a great job at providing the irrefutable evidence we need to prove ("demonstrate" is too weak a word) that FreeRice is a scam.
<h3>What does it all mean?</h3>
What do I mean when I say that FreeRice is a scam? Do I mean that it does not donate any rice whatsoever? Of course not--that would be nearly impossible to prove to be true because if that were the case, FreeRice would be very unlikely to get WFP endorsement. I only mean that there's an obvious but unmentioned disjoint between the number of grains of rice donated and the number of grains of rice that should have been donated (based on number of correct word submissions).

What does <em>that</em> mean? It means that although FreeRice.com should have donated <em>at least</em> 245 million grains of rice yesterday (Friday, February 1, 2008) based on the number of correct (and acknowledged) submissions, it only reportedly [donated 171.5 million grains](http://freerice.com/totals.php). What makes the 73.5 million grain deficit even more surprising is the fact that the minimum total does not include the contributions of millions of visitors to the site that day and those of others who have also used my AutoClicker. Because the average donation per day is around 150-180 million grains, the real deficit is very likely to be over 200 million grains. Isn't that enough of a lie to you? (Oh, by the way, those figures (150-180 million grains a day) are probably lies too)
<h3>How do you know?</h3>
My [autoclicker](node/200) verifies that each response from the server indicates that FreeRice.com has acknowledged our <em>correct</em> submission (which, according to the principle of the site, means 20 grains of rice will be donated) by checking each line of output for the string <code>correctDef</code>, which is the <code>id</code> of the <code>div</code> which appears <em>only</em> when the submission is correct; in other words, the grains of rice donated is incremented by 20 <em>only</em> when <code>serverOutput.indexOf("correctDef") != -1</code> evaluates to <code>true</code>. Hence, this methodology leaves no doubt that FreeRice.com reported at least 245 million/20 > 12 million <code>correct</code>s.
<h3>How can you be sure that your program donated that much rice?</h3>
We can't be; we can only know for certain how much FreeRice <em>should</em> donate--that FreeRice acknowledged that it <em>should</em> donate at least 245 million grains of rice (the approximate equivalent of 12 million correct submissions). But what if FreeRice doesn't donate that much rice, which is the case as the aforementioned numbers prove? It means FreeRice is a scam based on our collection of incontrovertible evidence supplied by our wonderful contributors. Yup, that's right: FreeRice acknowledged at least 245 million grains in pledged rice donations, yet reported a donation of only 171.5 million grains. If that's not just plain deception, I don't know what is.
<h3>So, where did the numbers come from?</h3>
Through a collective effort, we (the contributors) used the application to donate a collective total of 245 million grains of rice. Here are the contributors who have reported their totals to me:*
<ul>
<li><strong>Alex S + Joel L:</strong> 34,348,880 grains</li>
<li><strong>Tim J:</strong> 9.93 million grains</li>
<li><strong>Sunny A:</strong> 1,789,660 + 7,544,000 + 8,058,300 + 3,672,840 = 21,064,800 grains</li>
<li><strong>Cameron R:</strong> 2,876,040 grains</li>
<li><strong>Joe F:</strong> 57 million grains</li>
<li><strong>Tricia D:</strong> 9,630,100 + 1,795,960 + 9,780,020 = 21,206,080 grains</li>
<li><strong>Alex I:</strong> 3.24 million grains</li>
<li><strong>Albert Q:</strong> 226,000 + 930,000 + 4 million + 237,000 + 447,000 + 3 million = 8.84 million grains</li>
<li><strong>Me:</strong> 86.4 million grains</li>
<li><strong>Grand total:</strong> 245 million grains</li>
</ul>
(*) Please [contact me](user/1) if you want your name unlisted, if I forgot about you (or never got your contribution totals) or if you have screenshots of the app(s) before closing it (them).
<h3>But the World Food Program endorsed FreeRice!</h3>
Say FreeRice visitors submit 20 million correct words each day, which translates to a pledge of 400 million grains of rice. But because FreeRice.com and its sister site Poverty.com are not registered charities, they are under no obligation to report what they should report--after all, who will know if the creator declares that only 130 million grains should be donated when more than three times that were pledged? The answer is that no one will; the creator has no legal accountability (although I believe he has an ethical accountability), and the media was definitely eager to overlook that fact.

I have already shown that if FreeRice were completely honest with its rice counts, it would have made 1.4 million dollars in [revenue for December with the obligation to donate 10000 dollars](node/165) (less than 1% of the revenue) to WFP for it to purchase rice. Imagine if FreeRice made three or four times the calculated revenue simply by refusing to honestly report its totals--I wouldn't mind raking in 5 million dollars a month from an online operation that claims to "run the site at no profit." (so all the profit goes to the owner, not to impoverished people; that's a pretty clever way of saying the same thing).
<h3>At least FreeRice is doing SOMETHING!</h3>
If you understand simple economics, you would realize that you can do more by investing your time in more productive endeavors. Plus, it's not nice to be so deceptive. <em>If you have problems with what I have done, feel free to vent your irritation through the commenting box below (you need an account so I can ban you if you become disruptive :P)</em>; the Daily Cow promotes all non-disruptive and non-threatening forms of communication. Otherwise, don't complain about the organized campaign to seek the truth.
<h3>Random observation</h3>
I think it's funny that FreeRice adds harder words because playing the game with harder words means making more mistakes, which means that fewer grains of rice will be donated per page-load, which means greater revenue for each grain of rice. (Smart admin, I must admit)

Don't forget to spread the word and <a href="http://digg.com/odd_stuff/Incontrovertible_Evidence_That_FreeRice_Is_a_Scam"><strong>Digg this experiment</strong></a>; you should all be proud for being a part of our special edition of "Myth Busters" :P.

Minor disclaimer: this is based on the functionalities and behaviors of the site during the day we conducted this experiment; even if the admin decides to update FreeRice to be less susceptible to bots, our conclusion is not nulled.
