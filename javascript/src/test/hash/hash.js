class Music {
    musicId
    genres
    cntPlay
    
    constructor(musicId, genres, cntPlay = 0) {
        this.musicId = musicId
        this.genres = genres
        this.cntPlay = cntPlay
    }
}

function createGenreMap(musicMap = {}) {
    const genreMap = {};

    Object.values(musicMap).forEach(music => {
        if(!genreMap[music.genres]) {
            genreMap[music.genres] = []
        }
        genreMap[music.genres].push(music)
    })
    return genreMap
}

function createMusicMap(genres = [], plays = []) {
    const musicMap = {}
    
    genres.forEach((genre, index) => musicMap[index] = new Music(index, genre))
    plays.forEach((cntPlay, index) => musicMap[index].cntPlay = cntPlay)

    return musicMap
}

function createGenreTotalPlayMap(genreMap = {}) {
    const res = [];

    Object.keys(genreMap).forEach(key => {
        const total = genreMap[key].length === 1 ? genreMap[key][0].cntPlay : genreMap[key]
        .reduce((previous, current) => {
            if(typeof previous === 'object') {
                return previous.cntPlay + current.cntPlay
            }
            return previous + current.cntPlay
        })

        res.push({genre: key, total })
    })

    res.sort((a, b) => {
        if(a.total > b.total) {
            return -1
        } else if(a.total < b.total) {
            return 1;
        }
        return 0;
    });
    return res.map(total => total.genre);
}

function sortCntPlayDesc(a, b) {
    if(a.cntPlay > b.cntPlay) {
        return -1
    } else if(a.cntPlay < b.cntPlay) {
        return 1;
    }
    
    if(a.musicId > b.musicId) {
        return 1;
    } else if(a.musicId < b.musicId) {
        return -1;
    }

    return 0;
}

function solution(genres = [], plays = [], limitGenreMusic = 2) {
    const musicMap = createMusicMap(genres, plays)
    const genreMap = createGenreMap(musicMap)
    const genreTotalPlayList = createGenreTotalPlayMap(genreMap)

    Object.keys(genreMap).forEach(genre => genreMap[genre].sort(sortCntPlayDesc))
    Object.keys(genreMap).forEach(genre => genreMap[genre] = genreMap[genre].slice(0, 2))

    return genreTotalPlayList.map(genre => {
        return genreMap[genre].map(music => music.musicId)
    }).flat();
}

let inputGenres = ['classic', 'pop', 'classic', 'classic', 'pop']
let inputCntPlay = [500, 600, 150, 800, 2500]

console.log(solution(inputGenres, inputCntPlay))