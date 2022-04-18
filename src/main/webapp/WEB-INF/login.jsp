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
                        <title>Craig Burke - Candy - Login/Register</title>
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
                        <!-- Buttons -->
                        <div class="container w-75">
                            <!-- == Delete button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-danger float-end mb-3 me-3" href="/lookify/delete/${song.id}">Delete</a>
                            <p class="w-100"></p> -->
                            <!-- == Update button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-warning float-end mb-3 me-3" href="/lookify/newSong">Create Song</a>
                            <p class="w-100"></p> -->
                            <!-- == Top Ten button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-success float-end mb-3 me-3" href="/lookify/topTen">Top Ten</a>
                            <p class="w-100"></p> -->
                            <!-- == ShowOne button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-success float-end mb-3 me-3" href="/lookify/showSong">Show Song</a>
                            <p class="w-100"></p> -->
                            <!-- == Search button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-primary float-end mb-3 me-3" href="/lookify/search">Search</a>
                            <p class="w-100"></p> -->
                            <!-- == Dashboard button == -->
                            <!-- <p class="w-100"></p>
                            <a class="btn btn-primary float-end mb-3 me-3" href="/lookify/dashboard">Dashboard</a>
                            <p class="w-100"></p> -->



                            <!-- Beginning of Container -->
                            <div class="container mt-5">
                                <h1 class="text-danger text-center">
                                    <c:out value="${error}" />
                                </h1>
                                <div>
                                    <h1 class="bg-primary text-light text-center ps-5">Welcome to Candy CRUD</h1>
                                    <h1 class="bg-primary text-light text-center ps-5 mb-5">Log In or Register</h1>
                                </div>
                                <!-- <div><a class="btn btn-info mt-4" href="/candy/dashboard">Start Looking!</a></div> -->
                                <p class="w-100"></p>

                                <!-- Login/Registration Form START -->
                                <div class="container d-flex g-4">

                                    <div class="container">
                                        <h2 class="bg-primary text-light mb-2">LogIn</h2>
                                        <form:form action="/candy/login" method="post" modelAttribute="newLogin">
                                            <div class="form-group">
                                                <label>Email:</label>
                                                <form:input path="email" class="form-control" />
                                                <form:errors path="email" class="text-danger" />
                                            </div>
                                            <div class="form-group">
                                                <label>Password:</label>
                                                <form:password path="password" class="form-control" />
                                                <form:errors path="password" class="text-danger" />
                                            </div>
                                            <input type="submit" value="Login" class="btn btn-success mt-3" />
                                        </form:form>
                                    </div>

                                    <p class="w-25"></p>

                                    <div class="container">
                                        <h2 class="bg-primary text-light mb-2">Register</h2>
                                        <form:form action="/candy/register" method="post" modelAttribute="newUser">
                                            <div class="form-group">
                                                <label>User Name:</label>
                                                <form:input path="userName" class="form-control" />
                                                <form:errors path="userName" class="text-danger" />
                                            </div>
                                            <div class="form-group">
                                                <label>Email:</label>
                                                <form:input path="email" class="form-control" />
                                                <form:errors path="email" class="text-danger" />
                                            </div>
                                            <div class="form-group">
                                                <label>Password:</label>
                                                <form:password path="password" class="form-control" />
                                                <form:errors path="password" class="text-danger" />
                                            </div>
                                            <div class="form-group">
                                                <label>Confirm Password:</label>
                                                <form:password path="confirm" class="form-control" />
                                                <form:errors path="confirm" class="text-danger" />
                                            </div>
                                            <input type="submit" value="Register" class="btn btn-primary mt-3" />
                                        </form:form>
                                    </div>
                                </div>

                                <!-- Login/Registration Form END -->

                                <p class="w-100"></p>

                                <!-- End of Container -->
                            </div>
                        </div>
                    </body>

                    </html>