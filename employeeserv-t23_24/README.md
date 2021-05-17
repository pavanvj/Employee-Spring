Employee REST API: h2 In-memory database has been used to persist employee info

1. GET Employee: Returns employee information of a given id if it exists in the table.
GET Request: http://localhost:8080/v1/bfs/employee/2
Http Response: {
    "employee": {
        "id": 1,
        "first_name": "Sam",
        "last_name": "Turner",
        "date_of_birth": "11/11/1994",
        "address": {
            "line1": "No.06",
            "line2": "Tilak Nagar",
            "city": "Bangalore",
            "state": "Karnataka",
            "country": "India",
            "zip_code": 635526
        }
    }
}

Validation: Will return following response if employee id doesn’t exist in the DB
{
    "error": {
        "message": "Invalid Employee ID",
        "code": "INV_EMPID"
    }
}

2. Create Employee: Creates an Employee Resource if not already exists in database.

POST Request: http://localhost:8080/v1/bfs/employee
Request Body: {
    "id": 2,
    "first_name": "Sam",
    "last_name": "Turner",
    "date_of_birth": "11/11/1994",
    "address": {
        "line1": "No.06",
        "line2": "Tilak Nagar",
        "city": "Bangalore",
        "state": "Karnataka",
        "country":"India",
        "zip_code": 635526
    }
}

Http Response Status: 201 Created

Validations:
1. If Employee ID specified in the request already exists, then following error message will be returned {
    "error": {
        "message": "Employee ID: 2 already exists",
        "code": "EMP_EXISTS"
    }
2. Date of Birth validation: Only DoB with format dd/MM/yyyy will be accepted. Following is the response when request has invalid DoB {
    "error": {
        "message": "Invalid Date Format. Allowed Date Format: dd/MM/yyyy",
        "code": "INV_DOB"
    }
}

