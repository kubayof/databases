<div class="card">
    <div class="card-header" id="managersHeading">
        <h5 class="mb-0">
            <button class="btn btn-link" aria-expanded="true"
                    aria-controls="collapseOne">
                ProjectsTechnologies
            </button>
        </h5>
    </div>

    <div class="show" aria-labelledby="managersHeading">
        <div class="card-body">

            <div id="${gen.newId("accordion")}">
                <jsp:include page="/jsp/forms/projects_technologies/get_by_id.jsp"/>
                <jsp:include page="/jsp/forms/projects_technologies/get_by_project_id.jsp"/>
                <jsp:include page="/jsp/forms/projects_technologies/get_by_technology_id.jsp"/>
                <jsp:include page="/jsp/forms/projects_technologies/create_new.jsp"/>
                <jsp:include page="/jsp/forms/projects_technologies/delete.jsp"/>
            </div>
        </div>
    </div>
</div>