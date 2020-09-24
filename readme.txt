post 

http://localhost:9090/test/addTest
{
    "testTitle": "Demo Test",

    "testDuration": null,

    "testQuestions": [

      {

        "questionId": 17771,

        "questionTitle": "WHAT IS JAVAAAC??",

        "questionOptions": [

          {

            "id": 2331,

            "value": "HLLLLA"

          },

          {

            "id": 2112,

            "value": "PIIIA"

          },

          {

            "id": 22222,

            "value": "LANGUAGEEEC"

          },

          {

            "id": 20000,

            "value": "OOPSSSS"

          }

        ],

        "choice": 2,

        "marksScored": 1,

        "questionMarks": 1,

        "chosenAnswer": 2

      },

      {

        "questionId": 10009,

        "questionTitle": "BINARY TREEEEA",

        "questionOptions": [

          {

            "id": 10001,

            "value": "false"

          },

          {

            "id": 11110,

            "value": "false"

          },

          {

            "id": 12222,

            "value": "true"

          },

          {

            "id": 13334,

            "value": "false"

          }

        ],

        "choice": 2,

        "marksScored": 1,

        "questionMarks": 1,

        "chosenAnswer": 2

      }

    ],

    "testTotalMarks": 1000,

    "testMarksScored": null,

    "startTime": null,

    "endTime": null,

    "currentQuestion": 0

  }

======================================================
post 
http://localhost:9090/test/addQuestion/1

            {
                "questionId": 7070,
                "questionTitle": "WHAT IS Perl??",
                "questionOptions": [
                    {
                        "id": 2112,
                        "value": "PIIIA"
                    },
                    {
                        "id": 2331,
                        "value": "HLLLLA"
                    },
                    {
                        "id": 20000,
                        "value": "OOPSSSS"
                    },
                    {
                        "id": 22222,
                        "value": "LANGUAGEEEC"
                    }
                ],
                "choice": 2,
                "marksScored": 1,
                "questionMarks": 1,
                "chosenAnswer": 2
            }
			

==================================

put 

http://localhost:9090/test/updateQuestion/1
            {
                "questionId": 7070,
                "questionTitle": "WHAT IS C language??",
                "questionOptions": [
                    {
                        "id": 2110,
                        "value": "XXXX"
                    },
                    {
                        "id": 2331,
                        "value": "YYYY"
                    },
                    {
                        "id": 20000,
                        "value": "OOPSSSS"
                    },
                    {
                        "id": 22222,
                        "value": "LANGUAGEEEC"
                    }
                ],
                "choice": 2,
                "marksScored": 1,
                "questionMarks": 1,
                "chosenAnswer": 2
            }
			

			
			


