var app = new Vue({
	data: {
		id: null,
		// json取得用URL
		wp_url: CONST_API['wp_url'] + '/wp-json/wp/v2/posts/',
		post: [],
		errors: [],
	},
	mounted: function() {
		this.id = new URL(window.location.href).searchParams.get('id');
		axios.get(this.wp_url + this.id)
			.then(response => { this.post = response.data })
			.catch(
				error => { this.errors = error }
			);
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
});
app.$mount('#blog_detail');