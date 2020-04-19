import org.junit.Ignore;
import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;
@RunWith(Enclosed.class)
public class RestApiTest {

    public static class UserManagement {
        @Test
        public void noUsers() {
            String expected = new JSONObject().put("users", new JSONArray()).toString();
            String url = "/users";

            assertEquals(expected, RestApi().get(url));
        }

        @Ignore("Remove to run test")
        @Test
        public void addUser() {
            String expected = new JSONObject()
                .put("name", "Adama")
                .put("owes", new JSONObject())
                .toString();
            String url = "/add";
            JSONObject payload = new JSONObject().put("user", "Adam");

            assertEquals(expected, RestApi().post(url, payload));
        }

        /*
                {
                    "description": "add user",
                    "property": "post",
                    "input": {
                        "database": {
                            "users": []
                        },
                        "url": "/add",
                        "payload": {
                            "user": "Adam"
                        }
                    },
                    "expected": {
                        "name": "Adam",
                        "owes": {},
                        "owed_by": {},
                        "balance": 0.0
                    }
                },
                {
                    "description": "get single user",
                    "property": "get",
                    "input": {
                        "database": {
                            "users": [
                                {
                                    "name": "Adam",
                                    "owes": {},
                                    "owed_by": {},
                                    "balance": 0.0
                                },
                                {
                                    "name": "Bob",
                                    "owes": {},
                                    "owed_by": {},
                                    "balance": 0.0
                                }
                            ]
                        },
                        "url": "/users",
                        "payload": {
                            "users": ["Bob"]
                        }
                    },
                    "expected": {
                        "users": [
                            {
                                "name": "Bob",
                                "owes": {},
                                "owed_by": {},
                                "balance": 0.0
                            }
                        ]
                    }
                }

            ]
        */
    }
}

/*
{
    "exercise": "rest-api",
    "version": "1.1.1",
    "comments": [
      "The state of the API database before the request is represented",
      "by the input->database object. Your track may determine how this",
      "initial state is set.",
      "The input->payload and expected objects should be marshalled as",
      "strings in track implementation, as parsing and validating text",
      "payloads is an integral part of implementing a REST API.",
      "All arrays are ordered."
    ],
    "cases": [
        {
            "description": "iou",
            "cases": [
                {
                    "description": "both users have 0 balance",
                    "property": "post",
                    "input": {
                        "database": {
                            "users": [
                                {
                                    "name": "Adam",
                                    "owes": {},
                                    "owed_by": {},
                                    "balance": 0.0
                                },
                                {
                                    "name": "Bob",
                                    "owes": {},
                                    "owed_by": {},
                                    "balance": 0.0
                                }
                            ]
                        },
                        "url": "/iou",
                        "payload": {
                            "lender": "Adam",
                            "borrower": "Bob",
                            "amount": 3.0
                        }
                    },
                    "expected": {
                        "users": [
                            {
                                "name": "Adam",
                                "owes": {},
                                "owed_by": {
                                    "Bob": 3.0
                                },
                                "balance": 3.0
                            },
                            {
                                "name": "Bob",
                                "owes": {
                                    "Adam": 3.0
                                },
                                "owed_by": {},
                                "balance": -3.0
                            }
                        ]
                    }
                },
                {
                    "description": "borrower has negative balance",
                    "property": "post",
                    "input": {
                        "database": {
                            "users": [
                                {
                                    "name": "Adam",
                                    "owes": {},
                                    "owed_by": {},
                                    "balance": 0.0
                                },
                                {
                                    "name": "Bob",
                                    "owes": {
                                        "Chuck": 3.0
                                    },
                                    "owed_by": {},
                                    "balance": -3.0
                                },
                                {
                                    "name": "Chuck",
                                    "owes": {},
                                    "owed_by": {
                                        "Bob": 3.0
                                    },
                                    "balance": 3.0
                                }
                            ]
                        },
                        "url": "/iou",
                        "payload": {
                            "lender": "Adam",
                            "borrower": "Bob",
                            "amount": 3.0
                        }
                    },
                    "expected": {
                        "users": [
                            {
                                "name": "Adam",
                                "owes": {},
                                "owed_by": {
                                    "Bob": 3.0
                                },
                                "balance": 3.0
                            },
                            {
                                "name": "Bob",
                                "owes": {
                                    "Adam": 3.0,
                                    "Chuck": 3.0
                                },
                                "owed_by": {},
                                "balance": -6.0
                            }
                        ]
                    }
                },
                {
                    "description": "lender has negative balance",
                    "property": "post",
                    "input": {
                        "database": {
                            "users": [
                                {
                                    "name": "Adam",
                                    "owes": {},
                                    "owed_by": {},
                                    "balance": 0.0
                                },
                                {
                                    "name": "Bob",
                                    "owes": {
                                        "Chuck": 3.0
                                    },
                                    "owed_by": {},
                                    "balance": -3.0
                                },
                                {
                                    "name": "Chuck",
                                    "owes": {},
                                    "owed_by": {
                                        "Bob": 3.0
                                    },
                                    "balance": 3.0
                                }
                            ]
                        },
                        "url": "/iou",
                        "payload": {
                            "lender": "Bob",
                            "borrower": "Adam",
                            "amount": 3.0
                        }
                    },
                    "expected": {
                        "users": [
                            {
                                "name": "Adam",
                                "owes": {
                                    "Bob": 3.0
                                },
                                "owed_by": {},
                                "balance": -3.0
                            },
                            {
                                "name": "Bob",
                                "owes": {
                                    "Chuck": 3.0
                                },
                                "owed_by": {
                                    "Adam": 3.0
                                },
                                "balance": 0.0
                            }
                        ]
                    }
                },
                {
                    "description": "lender owes borrower",
                    "property": "post",
                    "input": {
                        "database": {
                            "users": [
                                {
                                    "name": "Adam",
                                    "owes": {
                                        "Bob": 3.0
                                    },
                                    "owed_by": {},
                                    "balance": -3.0
                                },
                                {
                                    "name": "Bob",
                                    "owes": {},
                                    "owed_by": {
                                        "Adam": 3.0
                                    },
                                    "balance": 3.0
                                }
                            ]
                        },
                        "url": "/iou",
                        "payload": {
                            "lender": "Adam",
                            "borrower": "Bob",
                            "amount": 2.0
                        }
                    },
                    "expected": {
                        "users": [
                            {
                                "name": "Adam",
                                "owes": {
                                    "Bob": 1.0
                                },
                                "owed_by": {},
                                "balance": -1.0
                            },
                            {
                                "name": "Bob",
                                "owes": {},
                                "owed_by": {
                                    "Adam": 1.0
                                },
                                "balance": 1.0
                            }
                        ]
                    }
                },
                {
                    "description": "lender owes borrower less than new loan",
                    "property": "post",
                    "input": {
                        "database": {
                            "users": [
                                {
                                    "name": "Adam",
                                    "owes": {
                                        "Bob": 3.0
                                    },
                                    "owed_by": {},
                                    "balance": -3.0
                                },
                                {
                                    "name": "Bob",
                                    "owes": {},
                                    "owed_by": {
                                        "Adam": 3.0
                                    },
                                    "balance": 3.0
                                }
                            ]
                        },
                        "url": "/iou",
                        "payload": {
                            "lender": "Adam",
                            "borrower": "Bob",
                            "amount": 4.0
                        }
                    },
                    "expected": {
                        "users": [
                            {
                                "name": "Adam",
                                "owes": {},
                                "owed_by": {
                                    "Bob": 1.0
                                },
                                "balance": 1.0
                            },
                            {
                                "name": "Bob",
                                "owes": {
                                    "Adam": 1.0
                                },
                                "owed_by": {},
                                "balance": -1.0
                            }
                        ]
                    }
                },
                {
                    "description": "lender owes borrower same as new loan",
                    "property": "post",
                    "input": {
                        "database": {
                            "users": [
                                {
                                    "name": "Adam",
                                    "owes": {
                                        "Bob": 3.0
                                    },
                                    "owed_by": {},
                                    "balance": -3.0
                                },
                                {
                                    "name": "Bob",
                                    "owes": {},
                                    "owed_by": {
                                        "Adam": 3.0
                                    },
                                    "balance": 3.0
                                }
                            ]
                        },
                        "url": "/iou",
                        "payload": {
                            "lender": "Adam",
                            "borrower": "Bob",
                            "amount": 3.0
                        }
                    },
                    "expected": {
                        "users": [
                            {
                                "name": "Adam",
                                "owes": {},
                                "owed_by": {},
                                "balance": 0.0
                            },
                            {
                                "name": "Bob",
                                "owes": {},
                                "owed_by": {},
                                "balance": 0.0
                            }
                        ]
                    }
                }
            ]
        }
    ]
}
*/