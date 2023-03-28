package com.bruxelles.bookitout.enums;

public enum RightsStatus {

    //A user who has no restrictions on his account
    NO_RESTRICTIONS,
    //A user who did violate some point of the web-app rules and who has been warned.
    WARNED,
    //A user who is temporary banned after violate the web-app rules
    TEMPORARY_BANNED,
    //A user definitely banned. He cannot join the web-app no more.
    DEFINITELY_BANNED,

}
