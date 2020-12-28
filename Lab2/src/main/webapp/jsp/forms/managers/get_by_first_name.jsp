<div class="card">
    <div class="card-header">
        <h5 class="mb-0">
            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#${gen.newId("collapse")}"
                    aria-expanded="false" aria-controls="${gen.getId("collapse")}">
                Get by first name
            </button>
        </h5>
    </div>
    <div id="${gen.getId("collapse")}" class="collapse" data-parent="#${gen.getId("accordion")}">
        <div class="card-body">
            <form action="/managers/first_name" method="GET">
                <div class="form-group">
                    <label for="${gen.newId("first_name")}">First name</label>
                    <input type="text" class="form-control" id="${gen.getId("first_name")}" name="first_name" value="Name">
                </div>
                <button type="submit" class="btn btn-primary">Get</button>
            </form>
        </div>
    </div>
</div>