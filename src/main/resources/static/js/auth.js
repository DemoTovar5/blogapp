import fetchData from "./fetchData.js";
import createView from "./createView.js";

/**
 * Adds a login event to allow the user to initially obtain a new OAuth2.0 token
 * On a successful response, sets the tokens into storage and redirects to the root
 */

// export function user
//
//
export function changePasswordEvent() {
    $("#update-btn").click(function () {

        let obj = {

            id: $("#user-id").val(),
            username: $("#username").val(),
            oldpassword: $("#old-password").val(),
            newpassword: $("#new-password").val()
        }

        let request = {
            method: "PUT",
            headers: {
                'Accept': 'application/json',
                "Content-Type": "application/json"
            },

        };

        // http://localhost:8080/api/users/1/updatePassword?oldPassword=old&newPassword=new

        fetch(`http://localhost:8080/api/users/${obj.id}/updatePassword?oldPassword=${obj.oldpassword}&newPassword=${obj.newpassword}`, request)
            .then((response) => {
                console.log(response.status)
                createView("/");
            });

    });


}


export function RegisterEvent() {
    $("#register-btn").click(function () {
        let obj = {
            email: $("#email").val(),
            username: $("#username").val(),
            password: $("#password").val()
        }

        let request = {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                "Content-Type": "application/json"
            },
            body: JSON.stringify(obj)
        };

        fetch("http://localhost:8080/api/users", request)
            .then((response) => {
                console.log(response.status)
                createView("/");
            });
    });
}

export default function addLoginEvent() {
    document.querySelector("#login-btn").addEventListener("click", function () {
        let obj = {
            username: document.querySelector("#username").value,
            password: document.querySelector("#password").value,
            grant_type: 'password'
        }

        let request = {
            method: "POST",
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Authorization': 'Basic ' + btoa('rest-blog-client:secret')
            },
            body: `grant_type=${obj.grant_type}&username=${obj.username}&password=${obj.password}&client_id=rest-blog-client`
        };

        fetchData(
            {
                route: `/oauth/token`
            },
            request).then((data) => {
            setTokens(data);
            createView("/");
        });
    });
}

/**
 * Gets the Authorization header needed for making requests to protected endpoints
 * This function should be used only after the user is logged in
 * @returns {boolean|{headers: {Authorization: string}}}
 */
export function getAuthBearerTokenHeader() {
    const token = localStorage.getItem("access_token");
    return token
        ? {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + `${token}`
        }
        : {'Content-Type': 'application/json'};
}

/**
 * Attempts to set the access and refresh tokens needs to authenticate and authorize the client and user
 * @param responseData
 */
function setTokens(responseData) {
    if (responseData.route['access_token']) {
        localStorage.setItem("access_token", responseData.route['access_token']);
        console.log("Access token set");
    }
    if (responseData.route['refresh_token']) {
        localStorage.setItem("refresh_token", responseData.route['refresh_token']);
        console.log("Refresh token set")
    }
}