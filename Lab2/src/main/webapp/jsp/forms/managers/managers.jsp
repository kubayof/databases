<div class="card">
    <div class="card-header" id="managersHeading">
        <h5 class="mb-0">
            <button class="btn btn-link" aria-expanded="true"
                    aria-controls="collapseOne">
                Managers
            </button>
        </h5>
    </div>

    <div class="show" aria-labelledby="managersHeading">
        <div class="card-body">

            <div id="${gen.newId("accordion")}">
                <jsp:include page="/jsp/forms/managers/get_by_id.jsp"/>
                <jsp:include page="/jsp/forms/managers/get_by_first_name.jsp"/>
                <jsp:include page="/jsp/forms/managers/get_by_last_name.jsp"/>
                <jsp:include page="/jsp/forms/managers/get_by_programmer_id.jsp"/>
                <jsp:include page="/jsp/forms/managers/get_by_project_id.jsp"/>
                <jsp:include page="/jsp/forms/managers/create_new.jsp"/>
                <jsp:include page="/jsp/forms/managers/update.jsp"/>
                <jsp:include page="/jsp/forms/managers/delete.jsp"/>
            </div>
        </div>
    </div>
</div>