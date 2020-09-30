import ClaySlider from '@clayui/slider';
import React, {useState, useEffect} from 'react';

const CapacitySlider = (props) => {
  const [value, setValue] = useState(0);

  useEffect(() => {
    props.parentCallback(value)
  }, [value]);

  return (
    <div className="form-group">
      <ClaySlider
        max={100}
        min={0}
        onValueChange={setValue}
        step={1}
        value={value}
        id="attendees"
      />
    </div>
  );
};

export default CapacitySlider;