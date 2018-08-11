Feature: Login for Leaftap
Background:
Given open the Browser
And Maximize the window
And Load the URL
And set the TimeOut
@smoke
Scenario Outline: Postive Login LeafTap
Given Enter the UserName as <username>
And Enter the password as <password>
When Click on Login button
Then Verify Login Is Successful

Examples:
|username|password|
|DemoSalesManager|crmsfa|

@sanity
Scenario Outline: Negative Login LeafTaps
Given Enter the UserName as <username>
And Enter the password as <password>
When Click on Login button
But Verify Login Is unSuccessful
Examples:
|username|password|
|DemoCSR|crmsfa1|

