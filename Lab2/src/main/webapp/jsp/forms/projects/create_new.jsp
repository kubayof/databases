<div class="card">
    <div class="card-header">
        <h5 class="mb-0">
            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#${gen.newId("collapse")}"
                    aria-expanded="false" aria-controls="${gen.newId("collapse")}">
                Insert new
            </button>
        </h5>
    </div>
    <div id="${gen.getId("collapse")}" class="collapse" data-parent="#${gen.getId("accordion")}">
        <div class="card-body">
            <form action="/managers/new" method="POST">
                <div class="form-group">
                    <label for="${gen.newId("name")}">Name</label>
                    <input type="text" class="form-control" id="${gen.getId("name")}" name="name" value="Name">
                </div>
                <div class="form-group">
                    <label for="${gen.newId("manager_id")}">Manager Id</label>
                    <input type="text" class="form-control" id="${gen.getId("manager_id")}" name="managerId" value="Name">
                </div>
                <button type="submit" class="btn btn-primary">Insert</button>
            </form>
        </div>
    </div>
</div>