<#import "common/header.ftl" as header>
<#import "common/sct.ftl" as script>
<!DOCTYPE html>
<html>

<@header.header title="${appSettings.title}" />

<body class="gray-bg">
    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name"><a href="/">IN+</a></h1>
            </div>
            <h3>Welcome to IN+</h3>
            <p>Login in. To see it in action.</p>
            <form class="m-t" role="form" action="/login" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="Username" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Password" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

                <a href="#"><small>Forgot password?</small></a>
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>
            </form>
            <p class="m-t"> <small>Base on Bootstrap 3 &copy; 2014</small> </p>
        </div>
    </div>
    <@script.js_main/>
</body>

</html>
