# test upload
Feature: open home page and upload file
Scenario: Upload File
Given Open home page "<browser>"
| chrome | https://wetransfer.com/ |
When click on upload
| manju.ostwal88@gmail.com | manjul5@gmail.com | sample file uploaded |
When file uploaded
Then Email code verification
| manju.ostwal88@gmail.com | Password@123 |
