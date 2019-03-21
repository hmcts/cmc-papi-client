package uk.gov.hmcts.cmc.domain.builders;

import uk.gov.hmcts.cmc.domain.models.timeline.Timeline;
import uk.gov.hmcts.cmc.domain.models.timeline.TimelineEvent;

import java.util.List;

import static java.util.Arrays.asList;

public class SampleTimeline {

    private List<TimelineEvent> events = asList(SampleTimelineEvent.builder().build());

    public static SampleTimeline builder() {
        return new SampleTimeline();
    }

    public static Timeline validDefaults() {
        return builder().build();
    }

    public SampleTimeline withEvents(List<TimelineEvent> events) {
        this.events = events;
        return this;
    }

    public Timeline build() {
        Timeline timeline = new Timeline();
        timeline.setRows(events);
        return timeline;
    }
}
