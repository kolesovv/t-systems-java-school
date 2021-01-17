<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Schedules</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="wrapper container">

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <!-- Brand -->
        <a class="navbar-brand" href="#">SBB</a>

        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Link 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link 2</a>
            </li>

            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Dropdown link
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Link 1</a>
                    <a class="dropdown-item" href="#">Link 2</a>
                    <a class="dropdown-item" href="#">Link 3</a>
                </div>
            </li>
        </ul>
    </nav>
    <div class="card-group">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">1: Select a Route</h5>
                <h6 class="card-subtitle mb-2 text-muted"></h6>
                <p class="card-text">Choose your departure and arrival destination. Select dates of travel.</p>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">2: Buy Tickets</h5>
                <h6 class="card-subtitle mb-2 text-muted"></h6>
                <p class="card-text">Select train, class of service, and number of tickets. Make a payment.</p>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">3: Go to the Station</h5>
                <h6 class="card-subtitle mb-2 text-muted"></h6>
                <p class="card-text">Receive your train tickets and enjoy your trip.</p>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <table class="table table-borderless">
                <thead>
                <tr>
                    <!-- <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th> -->
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Journey:</th>
                    <td>
                        <form>
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" class="custom-control-input" id="customRadio" name="example" value="customEx">
                                <label class="custom-control-label" for="customRadio">One way</label>
                            </div>
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" class="custom-control-input" id="customRadio2" name="example" value="customEx">
                                <label class="custom-control-label" for="customRadio2">Roundtrip</label>
                            </div>
                        </form>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row"><label for="departure">Departure City:</label></th>
                    <td>
                        <div class="form-group">
                            <input type="text" class="form-control" id="departure">
                        </div>
                    </td>
                    <th>Departure Date:</th>
                    <td>
                        <input type="text" class="form-control" id="departure">
                    </td>
                </tr>
                <tr>
                    <th scope="row"><label for="arrival">Arrival City:</label></th>
                    <td>
                        <div class="form-group">
                            <input type="text" class="form-control" id="arrival">
                        </div>
                    </td>
                    <th>Return Date:</th>
                    <td>
                        <input type="text" class="form-control" id="arrival">
                    </td>
                </tr>
                </tbody>
            </table>

        </div>
        <div class="col-sm-2"></div>
    </div>

    <footer class="footer">

    </footer>
</body>
</html>