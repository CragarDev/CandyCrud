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
                        <title>Craig Burke - Candy - Create New Owner</title>
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
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-danger float-end mb-3 me-3" href="/candy/delete/${candy.id}">Delete</a>
                            <p class="w-100"></p> -->

                            <!-- == Create New Candy button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-warning float-end mb-3 me-3" href="/candy/newCandy">Create Candy</a>
                            <p class="w-100"></p> -->

                            <!-- == Show One Candy button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-success float-end mb-3 me-3" href="/candy/showCandy">Show Candy</a>
                            <p class="w-100"></p> -->

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
                                <h1 class="bg-primary text-light ps-5">Create a new Owner</h1>
                            </div>

                            <p class="w-100"></p>

                            <!-- New Candy Form START -->
                            <div
                                class="container bg-secondary text-light rounded-3 w-50 mt-5 border border-info border-5 pb-5 p-3">
                                <form:form action="/candy/newOwner" method="post" modelAttribute="owner">



                                    <div class="mb-3">
                                        <p>
                                            <form:label path="firstName" class="float-start">First Name</form:label>
                                            <form:errors path="firstName" class="text-danger h5" />
                                            <form:input path="firstName" class="form-control text-dark"
                                                placeholder="firstName" />
                                        </p>
                                    </div>

                                    <div class="mb-3">
                                        <p>
                                            <form:label path="lastName" class="float-start">Last Name</form:label>
                                            <form:errors path="lastName" class="text-danger h5" />
                                            <form:input path="lastName" class="form-control text-dark"
                                                placeholder="lastName" />
                                        </p>
                                    </div>

                                    <br>
                                    <br>

                                    <input type="submit" value="Add New Owner" class="btn btn-warning float-start" />
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