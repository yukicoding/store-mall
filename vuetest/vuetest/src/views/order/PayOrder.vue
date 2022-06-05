<template>
    <div>
        <div>{{ payOrder }}</div>
        <div>wqeqw</div>
    </div>
</template>

<script>

export default {
    name: "payOrder",
    data() {
        return {
            payOrder: ""
        };
    },

    mounted() {
        console.log("qwweqw")
        let form = this.$route.query.html
        document.write(form);

    }
}

</script>
