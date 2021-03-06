import createView from "../createView.js";

export default function PostIndex(props) {
    return `
  <header>
    <h1>Posts Page</h1>
</header>
<main>
    <!--        CREATE FORM         -->
    <form>
        <div class="post">
            <div>
                <span>Post Title: </span>
            </div>
            <input id="create-post-title" type="text">
            <div>
                <span>Post Content: </span>
            </div>
            <input id="create-post-content" type="text">
        </div>
        <button id="create-btn">Submit</button>
    </form>
    
    <form>
     <input id="post-by-cat" type="text">
     <button id="search-by-cat">Search by Category</button>
     </form>
     
    <div class="post-container">
        ${props.posts.map(post =>
        `<h3 class="post-title" data-id="${post.id}">${post.title}</h3>
        <h4>${post.content}</h4>
        <p>Posted by: ${post.user.username}</p>
        <label for="edit-title">Edit Title</label>
        <input type="text" class="edit-title" value="${post.title}" readonly>
        <label for="edit-content">Edit Content</label>
        <input type="text" class="edit-content" value="${post.content}" readonly>
        <button data-id="${post.id}" class="edit-btn"">Edit</button>
        <button data-id="${post.id}" class="delete-btn"">Delete</button>

        `).join('')}
    </div>
</main>
    `;

}

export function PostsEvent(){
    CreateEvent()
    editEvent()
    deleteEvent()
    searchCategories()
}

function CreateEvent() {
    $('#create-btn').click(function () {
        let title = $("#create-post-title").val();
        let content = $("#create-post-content").val();

        let postObj = {
            "title": title,
            "content": content
        }

        let request = {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(postObj)
        }

        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status)
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        })
    })

}

        function editEvent() {
            $('.edit-btn').click(function () {
                console.log("event fired off")

                $(".edit-btn").text("Edit");
                $(".edit-title, .edit-content").attr("readonly", true);
                $(this).siblings(".edit-title, .edit-content").attr("readonly", false);
                $(this).text("Save");

               let posts = {
                   title: $(this).siblings(".edit-title").text(),
                   content: $(this).siblings(".edit-content").text()
               }

                let id = $(this).attr("data-id");

                let request = {
                    method: "PUT",
                    headers: {"Content-Type": "application/json"},
                    body: JSON.stringify(posts)
                }

                fetch(`http://localhost:8080/api/posts/${id}`, request)
                    .then(res => {
                        console.log(res.status)
                        createView("/posts")
                    }).catch(error => {
                    console.log(error);
                    createView("/posts")
                })
            })

        }

        function deleteEvent() {
            $(".delete-btn").click(function () {

                let request = {
                    method: "DELETE",
                    headers: {"Content-Type": "application/json"},
                }

                let id = $(this).attr("data-id");

                fetch(`http://localhost:8080/api/posts/${id}`, request)
                    .then(res => {
                        console.log(res.status);
                        createView("/posts");
                    })
                    .catch(error => {
                        console.log(error)
                        createView("/posts")
                    })
            })


        }

export function searchCategories(){
    $("#search-by-cat").click(function () {

           let categoryName = $("#post-by-cat").val()


        let request = {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                "Content-Type": "application/json"
            },
        };

        fetch(`http://localhost:8080/api/categories?categoryName=${categoryName}`, request)
            .then((response) => {
                console.log(response.status)
                createView("/posts");
            });

    })

}









