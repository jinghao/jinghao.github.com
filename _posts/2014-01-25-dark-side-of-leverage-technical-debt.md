---
layout: post
title: "Financial Leverage: An Allegory for Technical Debt"
categories: [finance, software, engineering, debt]
---
__You're the CEO of a young company__, and discover what appears to be a rare opportunity. It will require significant investments, but if it pays off, it will propel your company into the ranks of the world elite.

With little cash on hand, you decide to raise some capital from the debt and equity markets, backed by this promise. Now the pressure is on. You have more impatient investors breathing down your neck for results, while at the same time you're making increasingly costlier payments to service the debt.

A year down the road, you realize you had underestimated the cost, but you're near the end of your lifeline. Reluctantly, you plead your investors and creditors for more money and time. They agree with similar reluctance, but only with more punitive terms--twice the equity and interest. Your debt piles on, and you start to question whether this was a worthwhile venture.

Some time later, you finally start to see results. At this point, this will make or break your company. After having gambled so much on this opportunity and paid so dearly for it in other missed opportunities along the way, if this doesn't turn out, you've got nowhere to go.

<br />

__You're leading the infrastructure team__ within this company, and your CEO just announced a major opportunity for the company, reorganizing the company around this new strategy. The product teams, pushed to produce results ever more quickly, become impatient at your team's calmness. "We have to launch this soon or ...," they argue. "We'll clean it up as soon as we can," they said.

Little by little, your team relents to the pressure to take shortcuts. Every once in a while, some important requirement would change, and instead of implementing a holistic solution around the new requirements, teams layer on additional logic to "just make it work."

After a year, many experienced engineers have moved on, leaving behind a ball of legacy code that represents the accumulation of small cuts. The team left to maintain the infrastructure is spending increasing amounts of time firefighting issues they don't fully understand, or interpreting behaviors that were a result of some ad-hoc decision a long time ago. As the technical debts mount, the whole engineering org bleeds increasing amounts of time and energy.

### What Happened?

You made a levered bet. By definition, if the bet succeeds, you will reap larger rewards but if the bet flounders, you will pay greater costs. After you have committed to that bet (with the investment or technical push), your options are more constrained so you may miss out on other opportunities--whether it be a strategic investment or a technical direction you can build towards. And you will continue to pay for the debt until you return the principal--by paying down the debt/buying back the equity, or refactoring away the technical shortcuts--with each payment costing incrementally more (Highly-levered companies are riskier, so creditors and investors demand higher nominal returns, and the cost of layered debt grows not arithmetically but geometrically with the thickness of the layers).

Debt has a place, and it's when you have a high-conviction, unique and time-sensitive opportunity balanced with favorable terms (low equity, low interest, few concentrated but contained hacks). In that case, that debt may finance the investment to leapfrog to the next level, at which point you can pay back your debt with plenty left to invest into the next great opportunity.
