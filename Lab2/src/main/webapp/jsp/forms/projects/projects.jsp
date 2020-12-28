<div class="card">
    <div class="card-header" id="programmersHeading">
        <h5 class="mb-0">
            <button class="btn btn-link" aria-expanded="true"
                    aria-controls="collapseOne">
                Projects
            </button>
        </h5>
    </div>

    <div class="show" aria-labelledby="programmersHeading">
        <div class="card-body">

            <div id="${gen.newId("accordion")}">
                <jsp:include page="/jsp/forms/projects/get_by_id.jsp"/>
                <jsp:include page="/jsp/forms/projects/get_by_manager_id.jsp"/>
                <jsp:include page="/jsp/forms/projects/get_by_technology_id.jsp"/>
                <jsp:include page="/jsp/forms/projects/get_by_name.jsp"/>
                <jsp:include page="/jsp/forms/projects/create_new.jsp"/>
                <jsp:include page="/jsp/forms/projects/update.jsp"/>
                <jsp:include page="/jsp/forms/projects/delete.jsp"/>
            </div>
        </div>
    </div>
</div>