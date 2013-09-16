---
layout: post
title: My Custom Bookmarklets
created: 1235674681
categories:
- random
- programming
---
Bookmarklets are small Javascript applications stored in the URL of the link that, if dragged to your bookmark toolbar, can be used to do cool things when you click them. Here are a couple:
<ol>
<li><a href='javascript:if(myimgurl = prompt("Image URL", "")) document.getElementById("canvas_frame").contentDocument.getElementsByTagName("iframe")[document.getElementById("canvas_frame").contentDocument.getElementsByTagName("iframe").length-1].contentDocument.body.innerHTML += "<img src=\""+ myimgurl + "\" />"; void(0);'>Add an image to your Gmail message</a></li>
<li><a href='javascript:if(htmltoadd=prompt("HTML to add", ""))document.getElementById("canvas_frame").contentDocument.getElementsByTagName("iframe")[document.getElementById("canvas_frame").contentDocument.getElementsByTagName("iframe").length-1].contentDocument.body.innerHTML+=htmltoadd;void(0);'>Add HTML into your Gmail message</a> (a more general form of the above)</li>
<li><a href='javascript:var%20frames%20=%20document.getElementsByTagName("iframe");%20var%20set_to%20=%20!(document.body.contentEditable%20==%20"true");%20document.body.contentEditable%20=%20set_to;%20for(var%20i%20=%200;%20i%20<%20frames.length;%20i++)%20{%20frames[i].contentDocument.body.contentEditable%20=%20set_to;%20};%20void(0);'>Make all frames (and subframes) editable (click again to make them all uneditable)</a></li>
<li><a href='javascript:void(prompt("copy this",document.getElementsByClassName("spotlight")[0].src))'>Get the URL of the Facebook image you're viewing</a></li>
<li><a href='javascript:(function(item){varcleaned_content=item.innerHTML.replace(/,/,"");varwage=cleaned_content.match(/Wootwage:\$([\d,\.]+)/)[1];varpace=cleaned_content.match(/Orderpace:([\d\.]+)m([\d\.]+)s/);item.innerHTML+="<dd>Price: $"+(wage/3600*(60*pace[1]+pace[2]))+"</dd>";})($(".itemSummary")[0])'> Get prices for woots </a></li></ol>
Try them out! And if you like these, please [Digg this post](http://digg.com/programming/Adding_Images_to_Gmail_Messages).
