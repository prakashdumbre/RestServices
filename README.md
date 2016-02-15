FORMAT: 1A
HOST: http://localhost:8080

# Company Platform API

# API Root [/services]

# Group Company
Company resource-group is for resources

## Coampany [/companies]
Represents a company resource identified by companyId

### Create company [POST /companies]
Create the new company.
Indicates successful transition of a new record into database by returning 204 HTTP status code.

+ Request
    + Headers

            Accept:application/json
            Accept-Charset:UTF-8
            Accept-Encoding:compress;gzip
            Content-Type:application/json
            Content-Length:46

    + Body

            {
                "name" : "Wipro",
                "address" : "Mumbai",
                "city" : "Mumbai",
                "country" : "India",
                "email" : "test@test.com",
                "phoneNumber" : "878272883",
                "owners" : [1,2]
            }

+ Response 204
Response indicates successful creation of company resource
    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01

+ Response 409
Response indicates company identified by company name was already exist.
    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01
            Transfer-Encoding:chunked
            Content-Type:application/json
            Vary: Accept-Encoding, Accept

    + body

            {
                "companyId" : "1234",
            }

### Update company details [POST /companies/{companyId}/update]
Update the company details that are saved into system.
I.e. update can be done by changing any field including updation of company owners.
+ Request
    + Headers

            Accept:application/json
            Accept-Charset:UTF-8
            Accept-Encoding:compress;gzip
            Content-Type:application/json
            Content-Length:46

    + Body

            {
                "name" : "Wipro",
                "address" : "Pune",
                "city" : "Pune",
                "country" : "India",
                "email" : "test@test.com",
                "phoneNumber" : "878272883",
                "owners" : [6,7,8]
            }

+ Response 204
Response indicates successful updation of company details.
    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01

+ Response 404
Response indicates company update could not be entered as company identified by companyId is not found.

    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01

+ Response 400
Response indicates updates could not be entered as supplied data is invalid.
Http status reason phrase "Invalid data" will be sent.
All error codes and their descriptions will appear in the response body.

    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01
            Transfer-Encoding:chunked
            Content-Type:application/json
            Vary: Accept-Encoding, Accept

    + body

            {
                [
                    {
                        errorCode : "999",
                        errorDescription :  "Invalid company data."
                    }
                ]
            }

### Get company details [GET /companies/{companyId}]
Get the company details are saved into system.
+ Request
    + Headers

            Accept:application/json
            Accept-Charset:UTF-8
            Accept-Encoding:compress;gzip

+ Response 204
Response indicates successful execution of request.
    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01

+ Response 404
Response indicates company details could not be fined as company identified by companyId is not found.

    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01

+ Response 400
Response indicates successfull return company details.

    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01
            Transfer-Encoding:chunked
            Content-Type:application/json
            Vary: Accept-Encoding, Accept

    + body

             {
                "name" : "Wipro",
                "address" : "Pune",
                "city" : "Pune",
                "country" : "India",
                "email" : "test@test.com",
                "phoneNumber" : "878272883",
                "owners" : [6,7,8]
            }

### Find all company details [GET /companies ]
Get the all company details are saved into system.
+ Request
    + Headers

            Accept:application/json
            Accept-Charset:UTF-8
            Accept-Encoding:compress;gzip

+ Response 204
Response indicates successful execution of request.

    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01

+ Response 400
Response indicates successfull return all company details.

    + headers

            Server:Apache-Coyote/1.1
            Date:14/02/2016 00:00:01
            Transfer-Encoding:chunked
            Content-Type:application/json
            Vary: Accept-Encoding, Accept

    + body

             [
                {
                    "name" : "Wipro",
                    "address" : "Pune",
                    "city" : "Pune",
                    "country" : "India",
                    "email" : "test@test.com",
                    "phoneNumber" : "878272883",
                    "owners" : [6,7,8]
                },
                {
                    "name" : "Zycus",
                    "address" : "Mumbai",
                    "city" : "Mumbai",
                    "country" : "India",
                    "email" : "test2@test.com",
                    "phoneNumber" : "87325125",
                    "owners" : [2]
                }
            ]

