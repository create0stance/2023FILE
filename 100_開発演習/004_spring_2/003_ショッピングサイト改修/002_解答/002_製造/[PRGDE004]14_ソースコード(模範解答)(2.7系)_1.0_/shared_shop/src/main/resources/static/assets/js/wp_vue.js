var app = new Vue({
    components: {
        Hooper: window.Hooper.Hooper,
        Slide: window.Hooper.Slide,
        HooperPagination :  window.Hooper.Pagination,
    },
    data: {
		app_url : CONST_API['app_url'],
        // json取得用URL
        wp_url: CONST_API['wp_url'],
		blog_detail_path:CONST_API['app_context'] + CONST_API['blog_detail_path'],
        posts: [],
        errors: [],
        hooperSettings: {
            itemsToShow: 3,
            wheelControl: false,
            infiniteScroll:true,
            autoPlay:true,
            // hoverPause:false,
            playSpeed:3000
            // centerMode: true
        },
        bookName: null,
        genreId: 0,
        sort_key: null
    },
    mounted: function() {
        // store.dispatch('fetchTodos');
        // console.log(store.state.genres);
        console.log(this.wp_url);
        // https://www.willstyle.co.jp/blog/2751/
        axios.get(this.wp_url + CONST_API['posts'], {
                params: {
                    per_page: 20
                }
            }).then(response => { this.posts = response.data })
            .catch(
                error => { this.errors = error }
            );

        console.log(this.posts);

    },

    methods: {
        dateFormat: function(postDate) {
            const date = new Date(postDate)
            const year = date.getFullYear()
            const month = date.getMonth() + 1
            const day = date.getDate()
            return year + '/' + month + '/' + day
        },
    },
    watch: {
        posts: function(posts) {

        },
        bookName: function(bookName) {
            this.genreId = 0;
            this.wp_url.searchParams.set('bookName', bookName);
            this.wp_url.searchParams.delete('genreId');
            axios.get(this.wp_url.href).then(response => (this.books = response.data));
        },
        genreId: function(genreId) {
            this.bookName = null;
            this.wp_url.searchParams.set('genreId', genreId);
            this.wp_url.searchParams.delete('bookName');
            axios.get(this.wp_url.href).then(response => (this.books = response.data));
            console.log(this.wp_url.href);
        },

    },

})
app.$mount('#blogs');