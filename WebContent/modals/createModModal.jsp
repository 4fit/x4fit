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
                        <input type="text" class="form-control" id="username" required type="username"
                            placeholder="Enter Username" name="username">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" id="email" required type="email"
                            placeholder="Enter Email" name="email">
                    </div>
                    <div class="form-group">
                        <label for="fullname">Full Name</label>
                        <input type="text" class="form-control" id="fullname" required type="name"
                            placeholder="Enter Full Name" name="fullname">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="text" class="form-control" id="password" required type="password"
                            placeholder="Enter Password" name="password">
                    </div>
                    <div class="form-group">
                        <label for="confirm-password">Confirm Password</label>
                        <input type="text" class="form-control" id="confirm-password" required type="password"
                            placeholder="Enter Confirm Password">
                    </div>
                    <button type="submit" class="btn btn-primary text-xs-center">Create</button>
                </form>
            </div>
        </div>
    </div>
</div>