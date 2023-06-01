        // YouTube APIの読み込み
        const tag = document.createElement('script');
        tag.src = "https://www.youtube.com/iframe_api";

        const firstScriptTag = document.getElementsByTagName('script')[0];
        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

        //iframe player APIコードを非同期で読み込みます。
        let player;

        function onYouTubeIframeAPIReady() {
            //動画を埋め込む場所を指定(1.のidを入れる)
            player = new YT.Player('yt_player', {
                //オプションを設定する場所
                playerVars: {
                    autoplay: 1,
                    start: 40,
                    iv_load_policy: 3,
                    playsinline: 1,
                    loop: 1,
                    listType: 'playlist',
                    playlist: 'fK94N-62QGM', //上と同じ動画ID_リピートするには入力必須
                    rel: 0, // 関連動画の非表示
                    controls: 0, // 動画プレーヤーのコントロール非表示
					'origin': location.protocol + '//' + location.hostname + "/",
                },

                events: {
                    'onReady': onPlayerReady,
                    'onStateChange': onPlayerStateChange
                }
            });
        }

        //プレーヤの準備完了後に呼び出す関数
        function onPlayerReady(event) {
            event.target.mute(); //ミュートにしないとスマホで再生されない
            event.target.playVideo(); //ビデオを再生
        }

        // 再生開始時に行われる処理
        function onPlayerStateChange(event) {
            let ytStatus = event.target.getPlayerState();
            if (ytStatus == YT.PlayerState.ENDED) {
                event.target.mute(); //ミュートにしないとスマホで再生されない
                event.target.playVideo(); //ビデオを再生
            }
            if (event.data == 1) {
                loadingEnd();
            }
        }

        //loadingEnd();

        function loadingEnd() {
            document.getElementById('top-wrapper').style.opacity = 1; //動画の再生が始まったら表示
            document.getElementById('loading').style.display = "none";
        }