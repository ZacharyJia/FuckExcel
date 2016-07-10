<c:if test="${msg!=null}">
    <script type="text/javascript">
        Info.${msg.type}('${msg.msg}');
    </script>
</c:if>