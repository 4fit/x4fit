<!-- Create Mod Modal -->
<div class="modal fade" id="create-mod">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Create Mod</h3>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/admin/create-mod" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input class="form-control" id="username" required type="username" placeholder="Enter Username"
                            name="username">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input class="form-control" id="email" required type="email" placeholder="Enter Email"
                            name="email">
                    </div>
                    <div class="form-group">
                        <label for="fullname">Full Name</label>
                        <input class="form-control" id="fullname" required type="name" placeholder="Enter Full Name"
                            name="fullname">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input class="form-control" id="password" required type="password" placeholder="Enter Password"
                            minlength="8" name="password">
                    </div>
                    <div class="alert alert-danger d-none" id="alert" role="alert">
                        Password not match!
                    </div>
                    <div class="form-group">
                        <label for="confirm-password">Confirm Password</label>
                        <input class="form-control" id="confirm-password" required type="password" minlength="8"
                            placeholder="Enter Confirm Password">
                    </div>
                    <button type="button" id="btnCreateMod" onclick="createMod()"
                        class="btn btn-primary text-xs-center">Create</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function createMod() {
        const pass = document.getElementById('password').value;
        const rePass = document.getElementById('confirm-password').value;
        if (String(pass) === String(rePass)) {
            document.getElementById('btnCreateMod').type = 'submit';
        } else {
            let divAlert = document.getElementById('alert');
            divAlert.className = divAlert.className.replace(/\bd-none\b/g, "d-block");
        }
    }
</script>