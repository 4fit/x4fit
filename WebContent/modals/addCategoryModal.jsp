<!-- Add category Modal -->
<div class="modal fade" id="add-category">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Add Category</h3>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/mod/add-category" method="post">
                    <div class="form-group">
                        <label for="category-name">Category Name</label>
                        <input type="text" class="form-control" id="category-name" required
                            placeholder="Enter Category Name" name="category-name">
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control" id="description" rows="3" required
                            placeholder="Description here" name="description"></textarea>
                    </div>
                    <button type="submit" class="btn btn-success text-xs-center">Add</button>
                </form>
            </div>
        </div>
    </div>
</div>