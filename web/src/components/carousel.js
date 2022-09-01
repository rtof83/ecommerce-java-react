import React from 'react';

const Carousel = () => {
    return (
        <div id="myCarousel" className="carousel slide" data-ride="carousel">
            {/* <!-- Indicators --> */}
            <ol className="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" className="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            {/* <!-- Wrapper for slides --> */}
            <div className="carousel-inner" height role="listbox">
                <div className="item active">
                    <img src="https://img.freepik.com/free-vector/fashion-store-cloth-shop-interior-stuff-mannequin_107791-3014.jpg?w=2000" alt="store" />    
                </div>

                <div className="item">
                    <img src="https://cdn5.vectorstock.com/i/1000x1000/42/69/fashion-clothing-store-banner-with-shop-interior-vector-25134269.jpg" alt="store" />
                </div>

                <div className="item">
                    <img src="https://static.vecteezy.com/system/resources/previews/005/191/664/original/clothes-word-concepts-banner-clothing-store-fashion-casual-and-formal-wear-isolated-lettering-typography-idea-with-linear-icons-outline-illustration-vector.jpg" alt="store" />   
                </div>
            </div>

            {/* <!-- Left and right controls --> */}
            <a className="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span className="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span className="sr-only">Previous</span>
            </a>
            <a className="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span className="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span className="sr-only">Next</span>
            </a>
        </div>
    );
}

export default Carousel;
