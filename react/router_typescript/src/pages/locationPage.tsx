import React, { useEffect } from 'react';
import { useLocation } from 'react-router';

const LocationPage = () => {
    const location = useLocation();

    useEffect(() => {
        console.log(location);
    }, []);

    return (
        <div>
            <h2>LocationPage</h2>
        </div>
    );
};

export default LocationPage;
