1. Customer Management System
  
  1.1 Adding a customer
        
        URL: http://localhost:8084/customers (POST REQUEST)
        
        Sample Body:
{
        "first_name": "prakhar",
        "last_name": "yahjkk",
        "contact_no": "9909098980",
        "address": "jhkjshakshdkasjd"
}

  
   Note: When a new customer is added a new account will be created in the account managemen sytem linked with                     customer_idand 0.0 account_balance.


  1.2 Get a list of the customers
         
        URL: http://localhost:8084/customers (GET REQUEST)

        Sample Result:
[
    {
        "id": "0005598154139551228140635895087123065750",
        "first_name": "prakhar",
        "last_name": "yahjkk",
        "contact_no": "9909098980",
        "address": "jhkjshakshdkasjd",
        "accounts": [
            {
                "account_no": "0320388287310668637639821213972450277321",
                "account_balance": 10.0,
                "customer_id": "0005598154139551228140635895087123065750"
            },
            {
                "account_no": "0243150723706920273941473710230539030994",
                "account_balance": 1980.0,
                "customer_id": "0005598154139551228140635895087123065750"
            }
        ]
    },
    {
        "id": "0068708011978816572453985784069442114709",
        "first_name": "prakhar",
        "last_name": "yahjkk",
        "contact_no": "9909098980",
        "address": "jhkjshakshdkasjd",
        "accounts": [
            {
                "account_no": "0170242640093663586362118239288556812517",
                "account_balance": 0.0,
                "customer_id": "0068708011978816572453985784069442114709"
            }
        ]
    }
]


  1.3 Get a Customer Details (GET REQUEST)
           
          URL: http://localhost:8084/customers/{id} (GET REQUEST) 

          Sample Result:
{
    "id": "0068708011978816572453985784069442114709",
    "first_name": "prakhar",
    "last_name": "yahjkk",
    "contact_no": "9909098980",
    "address": "jhkjshakshdkasjd",
    "accounts": [
        {
            "account_no": "0170242640093663586362118239288556812517",
            "account_balance": 0.0,
            "customer_id": "0068708011978816572453985784069442114709"
        }
    ]
}

  1.4 Update customer's details

          URL: http://localhost:8084/customers/{id} (PUT REQUEST) 

Sample Body:
{
        "first_name": "prakhar",          // unchanged field
        "last_name": "yahjkk",            // unchanged field
        "contact_no": "9909098980",       // changed field
        "address": "jhkjshakshdkasjd"     // changed field
}

          Note: The RequestBody will contain changed and unchanged fields which will be handled by the frontend.

   1.5 Delete customer's details
            
          URL: http://localhost:8084/customers/{id} (DELETE REQUEST)

   

2. Account Management System
   
  2.1 Add a new account

         URL: http://localhost:8084/account (POST REQUEST)
         
         Sample Body:
{
        "account_balance":10,
        "customer_id::"98098002187642983498758"
}

  2.2 Withdraw money

         URL: http://localhost:8084/account/withdraw (POST REQUEST)

          Sample Body:
{
        "account_balance":10,                    // withdrawal amount
        "account_no"::"98098002187642983498758"
}

  2.3 Deposit money

         URL: http://localhost:8084/account/deposit (POST REQUEST)

          Sample Body:
{
        "account_balance":10,                    // Deposit amount
        "account_no"::"98098002187642983498758"
}

  2.4 Delete an account
            
          URL: http://localhost:8084/account/{id} (DELETE REQUEST)

  2.5 Get an account details
              
          URL: http://localhost:8084/account/{account_no} (GET REQUEST)

  