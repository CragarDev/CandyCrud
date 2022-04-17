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
                        <title>Craig Burke - Candy - Dashboard</title>
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
                            <p class="w-100"></p>
                            <a class="btn btn-warning float-end mb-3 me-3" href="/candy/newCandy">Create Candy</a>
                            <p class="w-100"></p>

                            <!-- == Show One Candy button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-success float-end mb-3 me-3" href="/candy/showOneCandy">Show One Candy</a>
                            <p class="w-100"></p> -->

                            <!-- == Update Candy button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-success float-end mb-3 me-3" href="/candy/updateCandy">Update Candy</a>
                            <p class="w-100"></p> -->

                            <!-- == Candy Dashboard button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-primary float-end mb-3 me-3" href="/candy/dashboard">Dashboard</a>
                            <p class="w-100"></p> -->

                        </div>
                        <!-- Buttons END -->

                        <!-- Main Container START -->
                        <div class="container text-center mt-5">

                            <div>
                                <h1 class="bg-primary text-light ps-5">Welcome to the Candy CRUD Dashboard</h1>
                            </div>

                            <p class="w-100"></p>



                            <!-- SCROLLING FROM BOOTSTRAP -->

                            <!-- Custom css that makes this example work like it does: -->
                            <style type="text/css">
                                .scrollspy-example {
                                    position: relative;
                                    height: 400px;
                                    margin-top: .5rem;
                                    overflow: auto;
                                }
                            </style>
                            <nav id="navbar-scrollspy" class="navbar navbar-light bg-light px-1">
                                <table class="table table-striped p-2 border border-2">
                                    <thead>
                                        <tr>
                                            <th scope="col" class="h4 text-center">Name</th>
                                            <th scope="col" class="h4 text-center">Brand</th>
                                            <th scope="col" class="h4 text-center">Rating</th>
                                            <th scope="col" class="h4 text-center">Price</th>
                                            <th scope="col" class="h4 text-center">Actions</th>
                                        </tr>
                                    </thead>
                                </table>
                            </nav>
                            <div data-bs-spy="scroll" data-bs-target="#navbar-scrollspy" data-bs-offset="0" tabindex="0"
                                class="scrollspy-example">
                                <table class="table table-striped p-2 border border-2">
                                    <tbody>
                                        <c:forEach var="candy" items="${candies}">
                                            <tr>
                                                <td scope="row">
                                                    <a href="/candy/showOneCandy/${candy.id}">
                                                        <p class="text-center">
                                                            <c:out value="${candy.name}"></c:out>
                                                        </p>
                                                    </a>
                                                </td>
                                                <td scope="row">
                                                    <p class="text-center">
                                                        <c:out value="${candy.brand}"></c:out>
                                                    </p>
                                                </td>
                                                <td scope="row">
                                                    <p class="text-center">
                                                        <c:out value="${candy.rating}"></c:out>

                                                    </p>
                                                </td>
                                                <td scope="row">
                                                    <p class="text-center">

                                                        <fmt:formatNumber value="${candy.price}" type="currency" />
                                                    </p>
                                                </td>
                                                <td scope="row">
                                                    <p class="text-center">
                                                        <a href="/candy/showOneCandy/${candy.id}">view</a>
                                                        <span> | </span>
                                                        <a href="/candy/updateCandy/${candy.id}">edit</a>
                                                        <span> | </span>
                                                        <a href="/candy/delete/${candy.id}">delete</a>
                                                    </p>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- end of scrolling table -->


                            <p class="w-100"></p>

                            <!-- Main Container END -->
                        </div>

                    </body>

                    </html>