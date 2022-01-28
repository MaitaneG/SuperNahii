using System;

namespace SuperNaaahi.Models
{
    /// <summary>
     /// Errorea bistaratzeko modeloa
     /// </summary>
    public class ErrorViewModel
    {
        public string RequestId { get; set; }

        public bool ShowRequestId => !string.IsNullOrEmpty(RequestId);
    }
}
