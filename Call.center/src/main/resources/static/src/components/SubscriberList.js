import { Subscriber } from "./Subscriber";
import StyleCard from "./CssCustom/StyleCard.css";
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";
import Back from "./CssCustom/BackgroundCarousel.css";


const responsive = {
  superLargeDesktop: {
    // the naming can be any, depends on you.
    breakpoint: { max: 4000, min: 3000 },
    items: 5,
  },
  desktop: {
    breakpoint: { max: 3000, min: 1024 },
    items: 3,
  },
  tablet: {
    breakpoint: { max: 1024, min: 464 },
    items: 2,
  },
  mobile: {
    breakpoint: { max: 464, min: 0 },
    items: 1,
  },
};

const SubscriberList = ({ data = [], onDelete }) => {
  const showdata = [];
  if (typeof data === "object" && Array.isArray(data)) {
    if (data.length === 0) {
      return <div className="alert alert-info">No data to display</div>;
    }
    return (
      <Carousel className=" " responsive={responsive}>
        {data.map((element) => {
          return (
            <div key={element.id} className="col-12 col-sm-6 col-lg-4">
              <Subscriber item={element} onDelete={onDelete} />
            </div>
          );
        })}
      </Carousel>
    );
  } else {
    showdata.push(data);
    return (
      <div className="row justify-content-center bg-info ">
        {showdata.map((element) => {
          return (
            <div key={element.id} className="col-12 col-sm-6 col-lg-4 m-5">
              <Subscriber item={element} />
            </div>
          );
        })}
      </div>
    );
  }
};
export { SubscriberList };
