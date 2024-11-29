<#macro kw>
  <div class=" min-h-screen sm:py-16 flex items-center justify-center items-center"
       style="background-image: url(&quot;${url.resourcesPath}/dist/img/my-login-bg.jpg&quot;);background-size: cover;">
    <div class="w-fit flex justify-center items-center w-full p-5 relative mx-auto my-auto rounded-xl shadow-lg bg-white"
         style="width: auto;padding: 49px; border-radius: .5rem;">
      <div class="items-center justify-center flex space-between"
           style="position: relative;display: flex;height: 100%;">
        <div class="text-center" style="display: flex;justify-content: center;">
          <img src="${url.resourcesPath}/dist/img/my-side-logo.png"
               alt="login illustration" style="width: 100%; height:100%;">
        </div>
        <div class="space-y-6 w-full ">
          <#nested>
        </div>
      </div>
    </div>
  </div>
</#macro>
