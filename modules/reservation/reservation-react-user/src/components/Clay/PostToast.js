import React, {useState} from 'react';
import ClayAlert from '@clayui/alert';
import { properties } from '../../properties';

const PostToast = (props) => {
    const [alert, setAlert] = useState(props.alert);
    const spritemap = properties.icons; 
    return !alert ? null : (
        <>
            <ClayAlert.ToastContainer>
                <ClayAlert
                    displayType="success"
                    autoClose={5000}                   
                    onClose={() => {
                        console.log("closed");
                        setAlert(false)
                    }}
                    spritemap={spritemap}
                    hideCloseIcon={false}
                    title={"Success:"}
                >
                    {`${props.name} is now a${props.type}.`}
                </ClayAlert>
            </ClayAlert.ToastContainer>
        </>
    );     
};
export default PostToast; 