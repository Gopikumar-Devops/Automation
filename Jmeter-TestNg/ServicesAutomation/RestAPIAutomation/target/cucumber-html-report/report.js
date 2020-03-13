$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GetBookByISBN.feature");
formatter.feature({
  "line": 1,
  "name": "Get book by ISBN",
  "description": "",
  "id": "get-book-by-isbn",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "User calls web service to get a book by its ISBN",
  "description": "",
  "id": "get-book-by-isbn;user-calls-web-service-to-get-a-book-by-its-isbn",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "a book exists with an isbn of 9781451648546",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "a user retrieves the book by isbn",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "response includes the following",
  "rows": [
    {
      "cells": [
        "totalItems",
        "1"
      ],
      "line": 8
    },
    {
      "cells": [
        "kind",
        "books#volumes"
      ],
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "response includes the following in any order",
  "rows": [
    {
      "cells": [
        "items.volumeInfo.title",
        "Steve Jobs"
      ],
      "line": 11
    },
    {
      "cells": [
        "items.volumeInfo.publisher",
        "Simon and Schuster"
      ],
      "line": 12
    },
    {
      "cells": [
        "items.volumeInfo.pageCount",
        "630"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "9781451648546",
      "offset": 30
    }
  ],
  "location": "BookTest.a_book_exists_with_isbn(String)"
});
formatter.result({
  "duration": 492730900,
  "status": "passed"
});
formatter.match({
  "location": "BookTest.a_user_retrieves_the_book_by_isbn()"
});
formatter.result({
  "duration": 1899711100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "BookTest.verify_status_code(int)"
});
formatter.result({
  "duration": 47195600,
  "status": "passed"
});
formatter.match({
  "location": "BookTest.response_equals(String,String\u003e)"
});
formatter.result({
  "duration": 347235100,
  "status": "passed"
});
formatter.match({
  "location": "BookTest.response_contains_in_any_order(String,String\u003e)"
});
formatter.result({
  "duration": 35732000,
  "status": "passed"
});
formatter.uri("Testcase1.feature");
formatter.feature({
  "line": 1,
  "name": "Get profile details of author",
  "description": "",
  "id": "get-profile-details-of-author",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "User calls web service to get profile details of an author",
  "description": "",
  "id": "get-profile-details-of-author;user-calls-web-service-to-get-profile-details-of-an-author",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "profile of an author with id one exists in the system",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "a user retrieves the profile by id",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "response contains the following details",
  "rows": [
    {
      "cells": [
        "title",
        "json-server"
      ],
      "line": 8
    },
    {
      "cells": [
        "author",
        "typicode"
      ],
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DemoTest.profile_of_an_author_with_id_one_exists_in_the_system$()"
});
formatter.result({
  "duration": 1300800,
  "status": "passed"
});
formatter.match({
  "location": "DemoTest.a_user_retrieves_the_profile_by_id$()"
});
formatter.result({
  "duration": 16303200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 26
    }
  ],
  "location": "DemoTest.verify_status_code(int)"
});
formatter.result({
  "duration": 370600,
  "status": "passed"
});
formatter.match({
  "location": "DemoTest.response_contains(String,String\u003e)"
});
formatter.result({
  "duration": 28503000,
  "status": "passed"
});
});