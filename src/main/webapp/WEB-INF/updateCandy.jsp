<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
    <!-- Here we have to import the Date class. -->
    <!-- You will put the import in the first line of the jsp tag. Use the import attribute -->

    <!-- c:out ; c:forEach ; c:if -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!-- Formatting (like dates) -->
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!-- form:form -->
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <!-- for rendering errors on PUT routes -->
                <%@ page isErrorPage="true" %>

                    <!DOCTYPE html>

                    <html>

                    <head>
                        <meta charset="UTF-8" />
                        <title>Craig Burke - Candy - Update Candy</title>
                        <!-- Bootstrap -->
                        <!-- CSS only -->
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                            crossorigin="anonymous" />
                        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
                            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
                            crossorigin="anonymous"></script>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
                            crossorigin="anonymous"></script>
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
                        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
                    </head>

                    <body>
                        <!-- Buttons START -->
                        <div class="container w-75">

                            <!-- == Delete Candy button == -->
                            <p class="w-100"></p>
                            <a class="btn btn-danger float-end mb-3 me-3" href="/candy/delete/${candy.id}">Delete</a>
                            <p class="w-100"></p>

                            <!-- == Create New Candy button == -->
                            <p class="w-100"></p>
                            <a class="btn btn-warning float-end mb-3 me-3" href="/candy/newCandy">Create Candy</a>
                            <p class="w-100"></p>

                            <!-- == Show One Candy button == -->
                            <p class="w-100"></p>
                            <a class="btn btn-success float-end mb-3 me-3" href="/candy/showOneCandy/${candy.id}">Show
                                Candy</a>
                            <p class="w-100"></p>

                            <!-- == Update Candy button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-success float-end mb-3 me-3" href="/candy/updateCandy">Update Candy</a>
                            <p class="w-100"></p> -->

                            <!-- == Candy Dashboard button == -->
                            <p class="w-100"></p>
                            <a class="btn btn-primary float-end mb-3 me-3" href="/candy/dashboard">Dashboard</a>
                            <p class="w-100"></p>

                        </div>
                        <!-- Buttons END -->

                        <!-- Main Container START -->
                        <div class="container text-center mt-5">

                            <div>
                                <h1 class="bg-primary text-light ps-5">Update a Candy</h1>
                            </div>

                            <p class="w-100"></p>

                            <h4>Make changes to ${candy.name} in the form below:</h4>
                            <!-- New Candy Form START -->
                            <div
                                class="container bg-secondary text-light rounded-3 w-50 mt-5 border border-info border-5 pb-5 p-3">
                                <form:form action="/candy/updateCandy/${candy.id}" method="post" modelAttribute="candy">
                                    <input type="hidden" name="_method" value="put" />



                                    <div class="mb-3">
                                        <p>
                                            <form:label path="name" class="float-start">Name</form:label>
                                            <form:errors path="name" class="text-danger h5" />
                                            <form:input path="name" class="form-control text-dark" placeholder="name" />
                                        </p>
                                    </div>

                                    <div class="mb-3">
                                        <p>
                                            <form:label path="brand" class="float-start">Brand</form:label>
                                            <form:errors path="brand" class="text-danger h5" />
                                            <form:input path="brand" class="form-control" placeholder="brand" />
                                        </p>
                                    </div>

                                    <div class="mb-3">
                                        <p>
                                            <form:label path="rating" class="float-start me-2">Rating:</form:label>
                                            <form:errors path="rating" class="text-danger h5" />
                                            <form:select path="rating" class="float-start">
                                                <form:option value="1" aria-selected="true">1</form:option>
                                                <form:option value="2">2</form:option>
                                                <form:option value="3">3</form:option>
                                                <form:option value="4">4</form:option>
                                                <form:option value="5">5</form:option>
                                                <form:option value="6">6</form:option>
                                                <form:option value="7">7</form:option>
                                                <form:option value="8">8</form:option>
                                                <form:option value="9">9</form:option>
                                                <form:option value="10">10</form:option>
                                            </form:select>
                                        </p>
                                    </div>
                                    <br>
                                    <br>


                                    <div class="mb-3">
                                        <p>
                                            <form:label path="price" class="float-start">Price:</form:label>
                                            <form:errors path="price" class="text-danger h5" />
                                            <br>
                                            <form:input type="number" step="0.01" path="price" class="form-control w-25"
                                                placeholder="price" />
                                        </p>
                                    </div>

                                    <div class="mb-3">
                                        <p>
                                            <form:label path="owner" class="float-start me-2">Owner:</form:label>
                                            <form:errors path="owner" class="text-danger h5" />
                                            <form:select path="owner" class="float-start">

                                                <!-- for each owner in owners -->
                                                <c:forEach items="${allOwners}" var="owner">
                                                    <form:option value="${owner.id}"
                                                        label="${owner.firstName} ${owner.lastName}">
                                                    </form:option> <!-- end of for each -->
                                                </c:forEach>

                                            </form:select>
                                        </p>
                                    </div>
                                    <br>
                                    <p class="w-100"></p>



                                    <input type="submit" value="Update Candy" class="btn btn-warning float-start" />
                                    <!-- == Cancel button == -->
                                    <p class="w-100"></p>
                                    <a class="btn btn-info float-end mb-3" href="/candy/dashboard">Cancel</a>
                                    <p class="w-100"></p>

                                </form:form>

                            </div>

                            <!-- New Candy Form END -->



                            <p class="w-100"></p>

                            <!-- Main Container END -->
                        </div>

                    </body>

                    </html>