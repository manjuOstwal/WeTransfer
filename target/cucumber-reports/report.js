$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/wetransfer/wetransfer/cucumberReport.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# test upload"
    }
  ],
  "line": 2,
  "name": "open home page and upload file",
  "description": "",
  "id": "open-home-page-and-upload-file",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Upload File",
  "description": "",
  "id": "open-home-page-and-upload-file;upload-file",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Open home page \"\u003cbrowser\u003e\"",
  "rows": [
    {
      "cells": [
        "chrome",
        "https://wetransfer.com/"
      ],
      "line": 5
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "click on upload",
  "rows": [
    {
      "cells": [
        "manju.ostwal88@gmail.com",
        "manju.ostwal5@gmail.com",
        "sample file uploaded"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "file uploaded",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Email code verification",
  "rows": [
    {
      "cells": [
        "manju.ostwal88@gmail.com",
        "leolovesmanju"
      ],
      "line": 10
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "WeTransferHomePage.open_Home_page(DataTable)"
});
formatter.result({
  "duration": 14111670200,
  "status": "passed"
});
formatter.match({
  "location": "WeTransferHomePage.click_on_upload(DataTable)"
});
formatter.result({
  "duration": 1589112200,
  "status": "passed"
});
formatter.match({
  "location": "WeTransferHomePage.file_uploaded()"
});
formatter.result({
  "duration": 8040927100,
  "status": "passed"
});
formatter.match({
  "location": "WeTransferHomePage.Email_code_verification(DataTable)"
});
formatter.result({
  "duration": 23979865200,
  "status": "passed"
});
});