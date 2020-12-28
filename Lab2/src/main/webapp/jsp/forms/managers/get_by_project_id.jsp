<div class="card">
    <div class="card-header">
        <h5 class="mb-0">
            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#${gen.newId("collapse")}"
                    aria-expanded="false" aria-controls="${gen.getId("collapse")}">
                Get by project Id
            </button>
        </h5>
    </div>
    <div id="${gen.getId("collapse")}" class="collapse" data-parent="#${gen.getId("accordion")}">
        <div class="card-body">
            <form action="/managers/project_id" method="GET">
                <div class="form-group">
                    <label for="${gen.newId("id")}">Projectr Id</label>
                    <input type="number" class="form-control" id="${gen.getId("id")}" name="project_id" value="1" min="1">
                </div>
                <button type="submit" class="btn btn-primary">Get</button>
            </form>
        </div>
    </div>
</div>