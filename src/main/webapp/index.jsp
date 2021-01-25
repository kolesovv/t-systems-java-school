<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
    <h1>Admin page</h1>
</div>

<div class="container">
    <div class="btn-group">
        <table class="table table-sm">
            <thead>
            <tr>
                <th>
                    <form action="station">
                    <button type="submit" class="btn btn-light">Show stations</button>
                    </form>
                </th>
                <th>
                    <form action="train">
                        <button type="submit" class="btn btn-light">Show trains</button>
                    </form>
                </th>
                <th>
                    <form action="passenger">
                        <button type="submit" class="btn btn-light">Show users</button>
                    </form>
                </th>
                <th>

                </th>
            </tr>
            </thead>
        </table>
    </div>
</div>

</body>
</html>

